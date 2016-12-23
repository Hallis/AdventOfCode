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

	// "" -> "
	@Test
	public void test_doublequotas()
	{
		List<String> data = ReadInput("Day08_exempel.txt");
		int[] mem = testklass.parse(data.get(0));
		assertEquals(2, mem[0]);
		assertEquals(0, mem[1]);
	}
	// "abc" -> "abc"
	@Test
	public void test_abc()
	{
		List<String> data = ReadInput("Day08_exempel.txt");
		int[] mem = testklass.parse(data.get(1));
		assertEquals(5, mem[0]);
		assertEquals(3, mem[1]);
	}
	// "aaa\"aaa" -> "aaa_aaa"
	@Test
	public void test_aaa_aaa()
	{
		List<String> data = ReadInput("Day08_exempel.txt");
		int[] mem = testklass.parse(data.get(2));
		assertEquals(10, mem[0]);
		assertEquals( 7, mem[1]);
	}
	// "\x27" --> "_"
	@Test
	public void test_hex27()
	{
		List<String> data = ReadInput("Day08_exempel.txt");
		int[] mem = testklass.parse(data.get(3));
		assertEquals(6, mem[0]);
		assertEquals(1, mem[1]);
	}

	@Test
	public void test_fas1()
	{
		int svar = 0;
		List<String> data = ReadInput("Day08.txt");

		for (int i=0; i < data.size(); i++) {
			int[] mem = testklass.parse(data.get(i));
			svar += (mem[0]-mem[1]);
		}
		
		System.out.println("Svar 2015, dag 08_1: " + svar);
		assertEquals(1371, svar);
	}
	@Test
	public void test_fas2()
	{
		int svar = 0;
		List<String> data = ReadInput("Day08.txt");

		for (int i=0; i < data.size(); i++) {
			int[] mem = testklass.parse(data.get(i));
			svar += (mem[1]-mem[0]);
		}
		
		System.out.println("Svar 2015, dag 08_2: " + svar);
		assertEquals(2117, svar);
	}

}
