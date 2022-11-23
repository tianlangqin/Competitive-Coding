package AdventOfCode2016;
import java.awt.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author /u/Philboyd_Studge on 11/30/2016.
 */
public class Advent2016_1 {

    enum Direction {
        NORTH(0,-1), EAST(1,0), SOUTH(0,1), WEST(-1,0);

        int dx, dy;
        Direction left, right;

        static {
            NORTH.left = WEST;
            NORTH.right = EAST;
            EAST.left = NORTH;
            EAST.right = SOUTH;
            SOUTH.left = EAST;
            SOUTH.right = WEST;
            WEST.left = SOUTH;
            WEST.right = NORTH;
        }
        Direction (int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

    static int manhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }



    public static void main(String[] args) throws FileNotFoundException {

        Set<Point> visited = new HashSet<>();
        int x = 0;
        int y = 0;
        visited.add(new Point(x, y));
        Direction current = Direction.NORTH;
        File file = new File("AdventOfCode2016/day1.txt");
        Scanner sc = new Scanner(file);
        String input = sc.nextLine();
        String[] instruction = input.split(",");

        for (String each : instruction) {
            String temp = each.trim();
            Boolean right = temp.startsWith("R");
            int dist = Integer.parseInt(temp.substring(1));

            if (right) {
                current = current.right;
            } else {
                current = current.left;
            }

            for (int i = 0; i < dist; i++) {
                x += current.dx;
                y += current.dy;
                Point p = new Point(x, y);
                if (visited.contains(p)) {
                    System.out.println("Visited: " + manhattanDistance(0,0, x, y));
                } else {
                    visited.add(p);
                }
            }
        }

        System.out.println("Final destination distance: " + manhattanDistance(0, 0, x, y));
    }
}