package se.hallis.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import se.hallis.aoc.Day02;

public class Day02Test extends TestBas {
    Day02 testklass;

    public Day02Test() {
	testklass = new Day02();
    }

    @Test
    public void total_area() {
	assertEquals(6, testklass.getPaketetsYta("1x1x1"));
	assertEquals(52, testklass.getPaketetsYta("2x3x4"));
	assertEquals(42, testklass.getPaketetsYta("1x1x10"));
    }

    @Test
    public void minsta_ytan() {
	assertEquals(1, testklass.getMinstaYtan("1x1x1"));
	assertEquals(6, testklass.getMinstaYtan("2x3x4"));
	assertEquals(1, testklass.getMinstaYtan("1x1x10"));
	assertEquals(12, testklass.getMinstaYtan("7x3x4"));
	assertEquals(2, testklass.getMinstaYtan("3x2x1"));
    }

    @Test
    public void bad_input() {
	assertEquals(0, testklass.getPaketetsYta("1x1"));
	assertEquals(0, testklass.getPaketetsYta("2x3x4x5"));
	assertEquals(0, testklass.getPaketetsYta(""));
	assertEquals(0, testklass.getPaketetsYta(null));
    }

    @Test
    public void total_consumption() {
	assertEquals(7, testklass.getTotalPaperNeed("1x1x1"));
	assertEquals(58, testklass.getTotalPaperNeed("2x3x4"));
	assertEquals(43, testklass.getTotalPaperNeed("1x1x10"));
    }

    @Test
    public void full_test_1() {
	int total_paper = 0;
	List<String> data = ReadInput("Day02.txt");
	for (String rad : data) {
	    // System.out.println( rad + " = " +
	    // testklass.getTotalPaperNeed(rad));
	    total_paper += testklass.getTotalPaperNeed(rad);
	}
	assertEquals(1588178, total_paper);
	System.out.println("Svar 2015, dag 02_1: " + total_paper);
    }

    @Test
    public void ribbon_length() {
	assertEquals(5, testklass.getRibbonLength("1x1x1"));
	assertEquals(34, testklass.getRibbonLength("2x3x4"));
	assertEquals(14, testklass.getRibbonLength("1x1x10"));
    }

    @Test
    public void full_test_2() {
	int total_paper = 0;
	List<String> data = ReadInput("Day02.txt");
	for (String rad : data) {
	    total_paper += testklass.getRibbonLength(rad);
	}
	assertEquals(3783758, total_paper);
	System.out.println("Svar 2015, dag 02_2: " + total_paper);
    }
}
