package se.hallis.test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import se.hallis.aoc.Day08;

/**
 * http://adventofcode.com/2015/day/8
 * 
 * @author mattias
 *
 */
public class Day08Test extends TestBas
{
	Day08 testklass;

	public Day08Test() {
		testklass = new Day08();
	}

	@Test
	public void test_do_stuff()
	{
		int[] mem = testklass.parse("");
		assertEquals(0, mem[0]);
	}

/*
	@Test
	public void test_fas1()
	{
		int svar = 0;
		List<String> data = ReadInput("Day07.txt");
		testklass.m_rawdata.addAll(data);
		testklass.dealWithIt();

		svar = testklass.getValueFromRegister("a");
		System.out.println("Svar 2015, dag 07_1: " + svar);
		assertEquals(16076, svar);
	}
*/
}
