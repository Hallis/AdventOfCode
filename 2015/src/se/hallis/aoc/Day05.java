package se.hallis.aoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://adventofcode.com/2015/day/5
 * 
 * @author mattias
 *
 */
public class Day05 extends AdventOfCodeBase {

    public boolean isStringNice_fas1(String text) {
	boolean result = true;

	if (text == null || text.length() < 3)
	    result = false;

	// Kolla ab, cd, pq, xy
	if (result) {
	    result = checkAB_CD_PQ_XY(text);
	}

	// Kolla tre vokaler
	if (result) {
	    result = checkThreeVowels(text);
	}

	// Kolla dubbla tecken
	if (result) {
	    result = checkDoubleChars(text);
	}
	return result;
    }

    public boolean isStringNice_fas2(String text) {
	boolean result = true;

	if (text == null || text.length() < 3)
	    result = false;

	// Kolla ab + ab
	if (result) {
	    result = checkDoublePairs(text);
	}

	// Kolla xyx
	if (result) {
	    result = checkXYX(text);
	}

	return result;
    }

    private boolean checkDoubleChars(String text) {
	boolean result = true;
	Pattern pattern = Pattern.compile("(\\w)\\1+");
	Matcher matcher = pattern.matcher(text);
	if (!matcher.find())
	    result = false;
	return result;
    }

    private boolean checkThreeVowels(String text) {
	int count = 0;
	boolean result = true;

	Pattern pattern = Pattern.compile("a|e|i|o|u");
	Matcher matcher = pattern.matcher(text);
	while (matcher.find())
	    count++;
	if (count < 3)
	    result = false;
	return result;
    }

    private boolean checkAB_CD_PQ_XY(String text) {
	boolean result = true;
	if (text.matches(".*(ab|cd|pq|xy).*"))
	    result = false;
	return result;
    }

    private boolean checkDoublePairs(String text) {
	boolean result = false;
	int len = text.length();
	
	for (int i = 0; i < len; i++) {
	    if (i + 2 <= len) {
		String x = text.substring(i, i + 2);
		for (int j = i + 2; j < len; j++) {
		    if (j + 2 <= len) {
			String y = text.substring(j, j + 2);
			if (x.equals(y)) {
			    result = true;
			}
		    }
		}
	    }
	}

	return result;
    }

    private boolean checkXYX(String text) {
	boolean result = false;
	for (int i = 0; i < text.length(); i++) {
	    if (i + 3 <= text.length()) {
		if (text.charAt(i) == text.charAt(i + 2)) {
		    result = true;
		    break;
		}
	    }
	}
	return result;
    }

}
