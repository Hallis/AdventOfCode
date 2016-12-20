package se.hallis.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import se.hallis.aoc.Day01;

public class Day01Test extends TestBas {
    Day01 testklass;

    public Day01Test() {
	testklass = new Day01();
    }

    @Test
    public void test_1_1() {
	assertEquals(0, testklass.getFloor("(())"));
	assertEquals(0, testklass.getFloor("()()"));
    }

    @Test
    public void test_1_2() {
	assertEquals(3, testklass.getFloor("((("));
	assertEquals(3, testklass.getFloor("(()(()("));
	assertEquals(3, testklass.getFloor("))((((("));
    }

    @Test
    public void test_1_3() {
	assertEquals(-1, testklass.getFloor("())"));
	assertEquals(-1, testklass.getFloor("))("));
    }

    @Test
    public void test_1_4() {
	assertEquals(-3, testklass.getFloor(")))"));
	assertEquals(-3, testklass.getFloor(")())())"));
    }

    @Test
    public void massivt_test_1() {
	List<String> data = ReadInput("Day01.txt");
	int svar = testklass.getFloor(data.get(0));
	assertEquals(232, svar);
	System.out.println("Svar 2015, dag 01_1: " + svar);

    }

    @Test
    public void test_2_1() {
	assertEquals(0, testklass.getPositionWhenSantaEntersBasement("(())"));
	assertEquals(0, testklass.getPositionWhenSantaEntersBasement("()()"));
    }

    @Test
    public void test_2_2() {
	assertEquals(1, testklass.getPositionWhenSantaEntersBasement("))((((("));
	assertEquals(7, testklass.getPositionWhenSantaEntersBasement("((())))"));
	assertEquals(5, testklass.getPositionWhenSantaEntersBasement("(()))"));
	assertEquals(19, testklass.getPositionWhenSantaEntersBasement("(()())(((()()())))))"));
    }

    @Test
    public void massivt_test_2() {
	List<String> data = ReadInput("Day01.txt");
	int svar = testklass.getPositionWhenSantaEntersBasement(data.get(0));
	assertEquals(1783, svar);
	System.out.println("Svar 2015, dag 01_2: " + svar);
    }

}
