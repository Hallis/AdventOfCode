package se.hallis.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import se.hallis.aoc.Day03;

/**
 * http://adventofcode.com/2015/day/3
 * 
 * @author mattias
 *
 */
public class Day03Test extends TestBas {
    Day03 testklass;

    public Day03Test() {
	testklass = new Day03();
    }

    @Test
    public void test_fas1() {
	assertEquals(2, testklass.tolkaData_1(">"));
	assertEquals(4, testklass.tolkaData_1("^>v<"));
	assertEquals(2, testklass.tolkaData_1("^v^v^v^v^v"));
    }
    @Test
    public void test_fas2() {
	assertEquals( 3, testklass.tolkaData_2("^v"));
	assertEquals( 3, testklass.tolkaData_2("^>v<"));
	assertEquals(11, testklass.tolkaData_2("^v^v^v^v^v"));
    }
    @Test
    public void full_test_1() {
	List<String> data = ReadInput("Day03.txt");
	int svar = testklass.tolkaData_1(data.get(0));
	System.out.println("Svar 2015, dag 03_1: " + svar);
	assertEquals(2081, svar);
    }
    @Test
    public void full_test_2() {
	List<String> data = ReadInput("Day03.txt");
	int svar = testklass.tolkaData_2(data.get(0));
	System.out.println("Svar 2015, dag 03_2: " + svar);
	assertEquals(2341, svar);
    }
}
