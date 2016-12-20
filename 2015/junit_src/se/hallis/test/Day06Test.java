package se.hallis.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import se.hallis.aoc.Day06_1;
import se.hallis.aoc.Day06_2;

/**
 * http://adventofcode.com/2015/day/4
 * 
 * @author mattias
 *
 */
public class Day06Test extends TestBas
{
	Day06_1 testklass;

	public Day06Test() {
		testklass = new Day06_1();
	}

	@Test
	public void test_parse_input()
	{
		String[] svar = testklass.parseInput("turn on 1,2 through 3,4");
		assertEquals(svar[0], "on");
		assertEquals(svar[1], "1");
		assertEquals(svar[2], "2");
		assertEquals(svar[3], "3");
		assertEquals(svar[4], "4");
		svar = testklass.parseInput("turn off 5,6 through 7,8");
		assertEquals(svar[0], "off");
		assertEquals(svar[1], "5");
		assertEquals(svar[2], "6");
		assertEquals(svar[3], "7");
		assertEquals(svar[4], "8");
		svar = testklass.parseInput("toggle 9,10 through 11,12");
		assertEquals(svar[0], "toggle");
		assertEquals(svar[1], "9");
		assertEquals(svar[2], "10");
		assertEquals(svar[3], "11");
		assertEquals(svar[4], "12");
	}

	@Test
	public void test_do_stuff()
	{
		testklass.doStuff("toggle 3,3 through 6,6");
		testklass.printArr();
	}
	@Test
	public void test_set_area()
	{
		testklass.setArea(1, 1, 8, 8, Day06_1.Operation.On);
		testklass.setArea(2, 2, 7, 7, Day06_1.Operation.Off);
		testklass.setArea(3, 3, 6, 6, Day06_1.Operation.On);
		testklass.setArea(4, 4, 5, 5, Day06_1.Operation.Off);
		assertEquals(40,  testklass.countNumberOfLit());

		testklass.setArea(0, 0,  9,  9, Day06_1.Operation.Toggle);
		assertEquals(60,  testklass.countNumberOfLit());
	}
	@Test
	public void test_toggle()
	{
		testklass.setAllLights(Day06_1.Operation.Off);
		testklass.setArea(0, 0,  0,  0, Day06_1.Operation.Toggle);
		testklass.setArea(1, 1,  1,  1, Day06_1.Operation.Toggle);
		testklass.printArr();
		assertEquals(2,  testklass.countNumberOfLit());
	}

	
	@Test
	public void test_fas1_exempel()
	{
		testklass.doStuff("turn on 0,0 through 999,999");		
		System.out.println("Antal tända " + testklass.countNumberOfLit());
		testklass.doStuff("toggle 0,0 through 999,0");		
		System.out.println("Antal tända " + testklass.countNumberOfLit());
		testklass.doStuff("turn off 499,499 through 500,500");		
		System.out.println("Antal tända " + testklass.countNumberOfLit());
	}

	@Test
	public void test_fas1()
	{
		int svar = 0;
		System.out.println("Antal tända " + testklass.countNumberOfLit());
		List<String> data = ReadInput("Day06.txt");
		for (int i = 0; i < data.size(); i++) {
//			System.out.println("Rad " + i + " = " + data.get(i));
			testklass.doStuff(data.get(i));
		}
		svar = testklass.countNumberOfLit();
		System.out.println("Svar 2015, dag 06_1: " + svar);
		assertEquals(400410, svar);
	}
	@Test
	public void test_fas2()
	{
		Day06_2 testklass = new Day06_2();
		int svar = 0;
		System.out.println("Antal tända " + testklass.countNumberOfLit());
		List<String> data = ReadInput("Day06.txt");
		for (int i = 0; i < data.size(); i++) {
			testklass.doStuff(data.get(i));
		}
		svar = testklass.countNumberOfLit();
		System.out.println("Svar 2015, dag 06_2: " + svar);
		assertEquals(15343601, svar);
	}

}
