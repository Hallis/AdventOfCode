package se.hallis.aoc;

/**
 * https://adventofcode.com/2015/day/5
 * 
 * @author mattias
 *
 */
public class Day06_1 extends AdventOfCodeBase
{
	public enum Operation {
		On, Off, Toggle
	};

	private final int MAX_X = 999; // 0..1
	private final int MAX_Y = 999; // 0..1

	private boolean[][] m_ledarr = new boolean[MAX_X + 1][MAX_Y + 1];

	public void setAllLights(Operation op)
	{
		setArea(0, 0, MAX_X, MAX_Y, op);
	}

	public void setArea(int startX, int startY, int endX, int endY, Operation op)
	{
		if (startX > endX) {
			int tmp = startX;
			startX = endX;
			endX = tmp;
		}
		if (startY > endY) {
			int tmp = startY;
			startY = endY;
			endY = tmp;
		}

		for (int x = startX; x <= endX; x++) {
			for (int y = startY; y <= endY; y++) {
				if (Operation.On == op)
					m_ledarr[x][y] = true;
				else if (Operation.Off == op)
					m_ledarr[x][y] = false;
				else
					m_ledarr[x][y] = !m_ledarr[x][y];
			}
		}
	}

	/*
	 * @formatter:off
	 * 
	 * toggle 333,60 through 748,159
	 * turn off 87,577 through 484,608
	 * turn on 809,648 through 826,999
	 * to
	 * toggle | 333 |  60 | 748 | 159
	 *    off |  87 | 577 | 484 | 608
	 *     on | 809 | 648 | 826 | 999
	 * 
	 * @formatter:on
	 * 
	 */

	public void doStuff(String text)
	{
		Operation op = null;
		String[] x = parseInput(text);

		if ("On".equalsIgnoreCase(x[0]))
			op = Operation.On;
		else if ("Off".equalsIgnoreCase(x[0]))
			op = Operation.Off;
		else if ("Toggle".equalsIgnoreCase(x[0]))
			op = Operation.Toggle;

		if (op != null) {
			setArea(x[1], x[2], x[3], x[4], op);
		} else {
			System.out.println("*** fel indata: " + text);
		}
	}

	private void setArea(String startX, String startY, String endX, String endY, Operation op)
	{
		setArea(Integer.parseInt(startX), Integer.parseInt(startY), Integer.parseInt(endX), Integer.parseInt(endY), op);
	}

	public String[] parseInput(String text)
	{
		text = text.replaceAll(",", " ");
		text = text.replaceAll("turn on", "on");
		text = text.replaceAll("turn off", "off");
		text = text.replaceAll("through ", "");
		return text.split(" ");
	}

	public void printArr()
	{
		for (int y = MAX_Y; y >= 0; y--) {
			for (int x = 0; x <= MAX_X; x++) {
				System.out.print(m_ledarr[x][y] ? "o" : "_");
			}
			System.out.println();
		}
	}

	public int countNumberOfLit()
	{
		int result = 0;
		for (int x = 0; x <= MAX_X; x++) {
			for (int y = 0; y <= MAX_Y; y++) {
				if (m_ledarr[x][y])
					result++;
			}
		}
		return result;
	}
}
