package se.hallis.aoc;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * https://adventofcode.com/2015/day/8
 * 
 * @author mattias
 *
 */
public class Day08 extends AdventOfCodeBase
{

	public int[] parse(String text)
	{
		int[] svar = {0, 0};
		svar[0] = text.length();
//		svar[1] = parseContentFas1(text);
		svar[1] = parseContentFas2(text);
		return svar;
	}

	private int parseContentFas1(String text)
	{
		// replace hex value
		text = text.replaceAll("(\\\\x)([0-9a-fA-F]){2}", "-");
		text = text.replaceAll("\\\\.", "-");
		int len = text.length();
		text = text.substring(1, len-1);
		return text.length();
	}
	

	private int parseContentFas2(String text)
	{
		text = StringEscapeUtils.escapeJava(text);
		return text.length() + 2;
	}
}