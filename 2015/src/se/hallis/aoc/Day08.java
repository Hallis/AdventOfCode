package se.hallis.aoc;

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
		svar[1] = parseContent(text);
		return svar;
	}

	private int parseContent(String text)
	{
		return 0;
	}
	
}