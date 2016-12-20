package se.hallis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import se.hallis.aoc.Day05;

/**
 * http://adventofcode.com/2015/day/4
 * 
 * @author mattias
 *
 */
public class Day05Test extends TestBas {
    Day05 testklass;

    public Day05Test() {
	testklass = new Day05();
    }

    @Test
    public void test_null() {
	boolean svar = testklass.isStringNice_fas1(null);
	assertFalse(svar);
    }

    @Test
    public void test_ab_cd_pq_xy() {
	assertFalse(testklass.isStringNice_fas1("xxxxabxxxx"));
	assertFalse(testklass.isStringNice_fas1("xxxxcdxxxx"));
	assertFalse(testklass.isStringNice_fas1("xxxxpqxxxx"));
	assertFalse(testklass.isStringNice_fas1("xxxxxyxxxx"));
	assertFalse(testklass.isStringNice_fas1("xxxxabxxab"));
	assertFalse(testklass.isStringNice_fas1("xxxxcdxxxy"));
	assertFalse(testklass.isStringNice_fas1("abcdpqxyxx"));
	assertFalse(testklass.isStringNice_fas1("xyxyxyxyxy"));
	assertTrue(testklass.isStringNice_fas1("fsa4rfaffsadfasd"));
    }

    @Test
    public void test_three_vowels() {
	assertTrue(testklass.isStringNice_fas1("xaxxexxxxix"));
	assertTrue(testklass.isStringNice_fas1("xaxxexxxxio"));
	assertTrue(testklass.isStringNice_fas1("seee"));
	assertFalse(testklass.isStringNice_fas1("xxxxxeek!"));
    }

    @Test
    public void test_double_chars() {
	assertTrue(testklass.isStringNice_fas1("acbdefghijj"));
    }

    @Test
    public void test_example_data_1() {
	assertTrue(testklass.isStringNice_fas1("ugknbfddgicrmopn"));
	assertTrue(testklass.isStringNice_fas1("aaa"));
	assertFalse(testklass.isStringNice_fas1("jchzalrnumimnmhp"));
	assertFalse(testklass.isStringNice_fas1("haegwjzuvuyypxyu"));
	assertFalse(testklass.isStringNice_fas1("dvszwmarrgswjxmb"));
    }

    @Test
    public void test_fas1() {
	int svar = 0;
	List<String> data = ReadInput("Day05.txt");
	for (int i = 0; i < data.size(); i++) {
	    String rad = data.get(i);
	    if (testklass.isStringNice_fas1(rad)) {
		svar++;
	    }
	}
	System.out.println("Svar 2015, dag 05_1: " + svar);
	assertEquals(236, svar);
    }


    @Test
    public void test_double_pairs() {
	assertFalse(testklass.isStringNice_fas2("acbdefghijj"));
	assertTrue(testklass.isStringNice_fas2("ajjdefeghijj"));
    }

    @Test
    public void test_xyx() {
	assertFalse(testklass.isStringNice_fas2("jjdefghijj"));
	assertTrue(testklass.isStringNice_fas2("ajjdexfxghijj"));
	assertTrue(testklass.isStringNice_fas2("ajjjdefghijj"));
    }
    @Test
    public void test_example_data_2() {
	assertTrue(testklass.isStringNice_fas2("qjhvhtzxzqqjkmpb"));
	assertTrue(testklass.isStringNice_fas2("xxyxx"));
	assertFalse(testklass.isStringNice_fas2("uurcxstgmygtbstg"));
	assertFalse(testklass.isStringNice_fas2("ieodomkazucvgmuy"));
    }
    
    @Test
    public void test_fas2() {
	int svar = 0;
	List<String> data = ReadInput("Day05.txt");
	for (int i = 0; i < data.size(); i++) {
	    String rad = data.get(i);
	    if (testklass.isStringNice_fas2(rad)) {
		svar++;
	    }
	}
	System.out.println("Svar 2015, dag 05_2: " + svar);
	assertEquals(51, svar);
    }
}
