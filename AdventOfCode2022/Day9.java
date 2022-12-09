package AdventOfCode2022;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;

public class Day9 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day9.txt");
        Scanner sc = new Scanner(file);
        int result = 0;
        //ArrayList<ArrayList<Character>> map = new ArrayList<>();
        char[][] map = new char[10001][10001];
        for (int i = 0; i < 10001; i++) {
            for (int j = 0; j < 10001; j++) {
                map[i][j] = '.';
            }
        }
        int tx = 5000;
        int ty = 5000;
        int hx = 5000;
        int hy = 5000;
        map[5000][5000] = '#';

        while(sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            int displacement = Integer.parseInt(input[1]);

            if (input[0].equals("U")) {
                for (int i = 0; i< displacement; i++) {
                    hy --;
                    if (Math.abs(hy - ty) >= 2 ) {
                        if (hx - tx > 0) {
                            ty--;
                            tx++;
                        } 
                        else if (hx - tx < 0 ) {
                            ty--;
                            tx--;
                        }
                        else {
                            ty--;
                        }
                    }
                    map[ty][tx] = '#';
                }
            }

            if (input[0].equals("D")) {
                for (int i = 0; i< displacement; i++) {
                    hy ++;
                    if (Math.abs(hy - ty) >= 2) {
                        if (hx - tx > 0) {
                            ty++;
                            tx++;
                        } 
                        else if (hx - tx < 0 ) {
                            ty++;
                            tx--;
                        }
                        else {
                            ty++;
                        }
                    }
                    map[ty][tx] = '#';
                }
            }

            if (input[0].equals("L")) {
                for (int i = 0; i< displacement; i++) {
                    hx --;
                    if (Math.abs(hx - tx) >= 2) {
                        if (hy - ty > 0) {
                            ty++;
                            tx--;
                        } 
                        else if (hy - ty < 0 ) {
                            ty--;
                            tx--;
                        }
                        else {
                            tx--;
                        }
                    }
                    map[ty][tx] = '#';
                }
            }

            if (input[0].equals("R")) {
                for (int i = 0; i< displacement; i++) {
                    hx ++;
                    if (Math.abs(hx - tx) >= 2) {
                        if (hy - ty > 0) {
                            ty++;
                            tx++;
                        } 
                        else if (hy - ty < 0 ) {
                            ty--;
                            tx++;
                        }
                        else {
                            tx++;
                        }
                    }
                    map[ty][tx] = '#';
                }
            }   
        }
        for (int i = 0; i < 10001; i++) {
            for (int j = 0; j < 10001; j++) {
                if (map[i][j] == '#') {
                    result++;
                }
            }
        }

        for (int i = 4990; i < 5011; i++) {
            for (int j = 4990; j < 5011; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println(result);
    }
}