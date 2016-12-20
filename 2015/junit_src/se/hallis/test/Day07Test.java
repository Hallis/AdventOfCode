package se.hallis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import se.hallis.aoc.Day07;

/**
 * http://adventofcode.com/2015/day/4
 * 
 * @author mattias
 *
 */
public class Day07Test extends TestBas
{
	Day07 testklass;

	public Day07Test() {
		testklass = new Day07();
	}

	@Test
	public void test_do_stuff()
	{
		testklass.printRegister();

		testklass.dealWithIt("123 -> x");
		testklass.dealWithIt("456 -> y");
		testklass.dealWithIt("x AND y -> d");
		testklass.dealWithIt("x OR y -> e");
		testklass.dealWithIt("x LSHIFT 2 -> f");
		testklass.dealWithIt("y RSHIFT 2 -> g");
		testklass.dealWithIt("NOT x -> h");
		testklass.dealWithIt("NOT y -> i");

		testklass.printRegister();
	}

	@Test
	public void test_numeric()
	{
		int tal = 27;
		int neg = ~tal & 0xffff;
		System.out.println(tal + " = " + (Integer.toString(tal, 2)));
		System.out.println(neg + " = " + (Integer.toString(neg, 2)));
	}

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

	@Test
	public void test_fas2()
	{
		int svar = 0;
		List<String> data = ReadInput("Day07.txt");
		testklass.m_rawdata.addAll(data);
		testklass.dealWithIt();

		svar = testklass.getValueFromRegister("a");
		System.out.println("Svar 2015, dag 07_2: " + svar);
		assertEquals(2797, svar);
	}
}
