package se.hallis.aoc;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * https://adventofcode.com/2015/day/4
 * 
 * @author mattias
 *
 */
public class Day04 extends AdventOfCodeBase {

    private final int MAX_BRUTE_FORCE_TRIES = 10000000;
    public int getHashNumber(String secretKey, String prefix) {

	MessageDigest md5 = null;
	try {
	    md5 = MessageDigest.getInstance("MD5");
	} catch (NoSuchAlgorithmException e) {
	    e.printStackTrace();
	}

	boolean keepGuessing = true;
	int nummer = 0;
	String key = "";
	while (keepGuessing && nummer < MAX_BRUTE_FORCE_TRIES) {
	    key = secretKey + nummer;
	    String md5hash = convertToHex(md5.digest(key.getBytes()));

	    if (md5hash.startsWith(prefix))
		keepGuessing = false;
	    else
		nummer++;
	}

	return nummer;
    }

    private static String convertToHex(byte[] data) {

	StringBuffer hexHash = new StringBuffer();
	for (int i = 0; i < data.length; i++) {
	    hexHash.append(Integer.toHexString((data[i] & 0xFF) | 0x100).toLowerCase().substring(1, 3));
	}

	return hexHash.toString();
    }

}
