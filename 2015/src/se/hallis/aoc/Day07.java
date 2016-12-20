package se.hallis.aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://adventofcode.com/2015/day/7
 * 
 * @author mattias
 *
 */
public class Day07 extends AdventOfCodeBase
{
	// register, storing variables with current value
	private Map<String, Integer> m_register = new HashMap<String, Integer>();
	public List<String> m_rawdata = new ArrayList<String>();

	public void dealWithIt(String text)
	{
		String[] apa = text.toLowerCase().split("->");
		String key = apa[1].trim();
		String value = apa[0].trim();
		Integer realVal = parse(value);
		store(key, realVal);
	}

	public int getValueFromRegister(String key)
	{
		return m_register.get(key).intValue();
	}

	/**
	 * @formatter:off
	 * 
	 *        123 -> x
	 *        456 -> y
	 *    x AND y -> z
	 *     x OR y -> z
	 * x LSHIFT 2 -> z
	 * x RSHIFT 2 -> z
	 *      NOT x -> z
	 * 
	 * @formatter:on
	 */
	private Integer parse(String value)
	{
		Integer result = new Integer(0);
		String[] apa = value.split(" ");

		// Tilldelning 123 -> x
		if (apa.length == 1) {
			result = Integer.parseInt(apa[0]);
		}
		// NOT 123 -> x, NOT x -> y
		else if (apa.length == 2) {
			result = negate(getRealValue(apa[1]));
		}
		// OPERATION
		else if (apa.length == 3) {
			result = calculate(apa[1], getRealValue(apa[0]), getRealValue(apa[2]));
		}

		return result;
	}

	private Integer calculate(String op, Integer val1, Integer val2)
	{
		Integer result = null;

		if ("AND".equalsIgnoreCase(op)) {
			result = val1 & val2;
		} else if ("OR".equalsIgnoreCase(op)) {
			result = val1 | val2;
		} else if ("LSHIFT".equalsIgnoreCase(op)) {
			result = val1 << val2;
		} else if ("RSHIFT".equalsIgnoreCase(op)) {
			result = val1 >> val2;
		}

		return result;
	}

	private Integer negate(Integer realValue)
	{
		return ~realValue & 0xffff;
	}

	/**
	 * Returnerar x eller matchat värde från register om x är numeriskt
	 * 
	 * @param x
	 * @return
	 */
	private Integer getRealValue(String x)
	{
		Integer i = m_register.get(x);
		if (isNumeric(x)) {
			i = new Integer(x);
		}
		return i;
	}

	private void store(String key, Integer value)
	{
		m_register.put(key, value);
	}

	public void printRegister()
	{
		System.out.println("Register content:");
		System.out.println(m_register);
	}

	public boolean isNumeric(String val)
	{
		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void dealWithIt()
	{
		boolean somethingChanged = false;
		// int sizeBefore = m_rawdata.size();
		for (int i = 0; i < m_rawdata.size(); i++) {
			somethingChanged |= doStuff(m_rawdata.get(i), i);
		}

		// fortsätt jobba så länge det finns saker att göra
		if (somethingChanged)
			dealWithIt();
		
	}

	private boolean doStuff(String text, int index)
	{
		boolean result = false;
		if (text.length() > 0) {
			String[] tmp = text.toLowerCase().split("->");
			String key = tmp[1].trim();
			String[] opArr = tmp[0].trim().split(" ");
			//
			// x -> y
			//
			if (opArr.length == 1) {
				Integer value = getValue(opArr[0]);
				if (value != null) {
					// fulhack för uppgift 2
					if (key.equals("b"))
						value = 16076;
					// --slut
					m_register.put(key, value);
					result = true;
				}
			}
			//
			// not x -> y
			//
			else if (opArr.length == 2) {
				Integer value = getValue(opArr[1]);
				if (value != null) {
					m_register.put(key, negate(value));
					result = true;
				}
			}
			//
			// x blabla y -> z
			//
			else if (opArr.length == 3) {
				Integer value1 = getValue(opArr[0]);
				Integer value2 = getValue(opArr[2]);
				String op = opArr[1];

				if (value1 != null && value2 != null) {
					m_register.put(key, calculate(op, value1, value2));
					result = true;
				}
			}
			if (result)
				m_rawdata.set(index, "");
		}
		return result;
	}

	private Integer getValue(String value)
	{
		Integer result;
		if (isNumeric(value)) {
			result = new Integer(value);
		} else {
			result = m_register.get(value);
		}
		return result;
	}
}