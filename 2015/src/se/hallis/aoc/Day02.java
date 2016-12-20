package se.hallis.aoc;

import java.util.ArrayList;
import java.util.Collections;

/**
 * http://adventofcode.com/2015/day/2
 * 
 * @author mattias
 *
 */
public class Day02 extends AdventOfCodeBase {

    public int getPaketetsYta(String bhd) {
	int result = 0;
	ArrayList<Integer> lista = getDimensionArr(bhd);

	if (lista.size() == 3) {
	    int b = lista.get(0);
	    int h = lista.get(1);
	    int d = lista.get(2);

	    result = (2 * b * h) + (2 * b * d) + (2 * h * d);
	}
	return result;
    }

    public int getMinstaYtan(String bhd) {
	int result = 0;
	ArrayList<Integer> lista = getDimensionArr(bhd);

	if (lista.size() >= 2)
	    result = lista.get(0) * lista.get(1);

	return result;
    }

    public int getTotalPaperNeed(String bhd) {
	int minsta_ytan = getMinstaYtan(bhd);
	int total_yta = getPaketetsYta(bhd);

	return total_yta + minsta_ytan;
    }

    public int getRibbonLength(String bhd) {
	int result = 0;
	ArrayList<Integer> lista = getDimensionArr(bhd);
	if (lista.size() == 3) {
	    int bow_length = lista.get(0) * lista.get(1) * lista.get(2);
	    int ribbon_length = 2 * lista.get(0) + 2 * lista.get(1);
	    result = ribbon_length + bow_length;
	}
	return result;
    }

    private ArrayList<Integer> getDimensionArr(String bhd) {
	ArrayList<Integer> lista = new ArrayList<Integer>();
	if (bhd != null) {
	    String[] bhd_arr = bhd.split("x");

	    if (bhd_arr.length == 3) {
		lista.add(new Integer(bhd_arr[0]));
		lista.add(new Integer(bhd_arr[1]));
		lista.add(new Integer(bhd_arr[2]));
		Collections.sort(lista);
	    }
	}
	return lista;
    }
}
