package se.hallis.aoc;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Day03 extends AdventOfCodeBase {

    public int tolkaData_1(String indata) {
	int x = 0;
	int y = 0;

	Map<Point, Object> map = new HashMap<Point, Object>();

	if (indata.length() > 0) {
	    map.put(new Point(x, y), null);
	    for (int i = 0; i < indata.length(); i++) {
		char c = indata.charAt(i);
		if (c == '^')
		    y++;
		else if (c == 'v' || c == 'V')
		    y--;
		else if (c == '<')
		    x--;
		else if (c == '>')
		    x++;
		map.put(new Point(x, y), null);
	    }
	}
	return map.size();
    }

    public int tolkaData_2(String indata) {
	int x = 0;
	int y = 0;

	Map<String, String> map = new HashMap<String, String>();

	if (indata.length() > 0) {
	    Point santa = new Point(0, 0);
	    Point robot = new Point(0, 0);

	    map.put(getCoord(santa), "");

	    for (int i = 0; i < indata.length(); i++) {
		x = 0;
		y = 0;
		char c = indata.charAt(i);
		if (c == '^')
		    y++;
		else if (c == 'v' || c == 'V')
		    y--;
		else if (c == '<')
		    x--;
		else if (c == '>')
		    x++;

		if (i % 2 == 0) {
		    santa.move(santa.x + x, santa.y + y);
		    map.put(getCoord(santa), "");
		} else {
		    robot.move(robot.x + x, robot.y + y);
		    map.put(getCoord(robot), "");
		}
	    }
	}
	return map.size();
    }

    private String getCoord(Point p) {
	return "(" + p.x + ", " + p.y + ")";
    }
}
