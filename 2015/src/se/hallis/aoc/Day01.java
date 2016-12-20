package se.hallis.aoc;

/**
 * http://adventofcode.com/2015/day/1
 * 
 * @author mattias
 *
 */
public class Day01 extends AdventOfCodeBase {

    public int getFloor(String input) {
	String upp = input.replaceAll("[^(]", "");
	String ner = input.replaceAll("[^)]", "");
	return upp.length() - ner.length();
    }

    public int getPositionWhenSantaEntersBasement(String input) {
	int aktuell_vaning = 0;
	int pos = 0;

	for (int i = 0; i < input.length(); i++) {

	    if (input.charAt(i) == '(')
		aktuell_vaning++;
	    else if (input.charAt(i) == ')')
		aktuell_vaning--;

	    if (aktuell_vaning == -1) {
		pos = i + 1;
		break;
	    }
	}
	return pos;
    }
}
