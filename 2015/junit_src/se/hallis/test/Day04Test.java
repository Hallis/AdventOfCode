package se.hallis.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import se.hallis.aoc.Day04;

/**
 * http://adventofcode.com/2015/day/4
 * 
 * @author mattias
 *
 */
public class Day04Test extends TestBas {
    Day04 testklass;

    public Day04Test() {
	testklass = new Day04();
    }

    @Test
    public void test_1() {
	System.out.print("Letar efter heltal för abcdef<nummer> -> 00000... ");
	int svar = testklass.getHashNumber("abcdef", "00000");
	System.out.println("" + svar);
	assertEquals(609043, svar);
    }

    @Test
    public void test_2() {
	System.out.print("Letar efter heltal för pqrstuv<nummer> -> 00000... ");
	int svar = testklass.getHashNumber("pqrstuv", "00000");
	System.out.println("" + svar);
	assertEquals(1048970, svar);
    }

    @Test
    public void test_fas1() {
	System.out.print("Letar efter heltal för ckczppom<nummer> -> 00000... ");
	int svar = testklass.getHashNumber("ckczppom", "00000");
	System.out.println("" + svar);
	assertEquals(117946, svar);
    }

    @Test
    public void test_fas2() {
	System.out.print("Letar efter heltal för ckczppom<nummer> -> 000000... ");
	int svar = testklass.getHashNumber("ckczppom", "000000");
	System.out.println("" + svar);
	assertEquals(3938038, svar);
    }
}
