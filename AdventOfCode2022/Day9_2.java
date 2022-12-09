package AdventOfCode2022;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;

public class Day9_2 {

    static char[][] map = new char[10001][10001];
    static int[] xcor = new int[10];
    static int[] ycor = new int[10];
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day9.txt");
        Scanner sc = new Scanner(file);
        int result = 0;
        //ArrayList<ArrayList<Character>> map = new ArrayList<>();
        
        for (int i = 0; i < 10001; i++) {
            for (int j = 0; j < 10001; j++) {
                map[i][j] = '.';
            }
        }
        
        for (int i = 0; i < 10; i++) {
            xcor[i] = 5000;
            ycor[i] = 5000;
        }
        map[5000][5000] = 's';

        while(sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            //System.out.println(input[0]);
            int displacement = Integer.parseInt(input[1]);
            String direction = input[0];

            if (input[0].equals("U")) {
                for (int i = 0; i< displacement; i++) {
                    ycor[0] --;
                    for (int j = 0 ; j < 9; j++) {
                        if (j == 4) {
                            System.out.println(ycor[j] + " " + xcor[j]);
                            System.out.println(ycor[j + 1] + " " + xcor[j + 1]);
                            System.out.println();
                        }
                        moveU(j);
                        moveD(j);
                        moveL(j);
                        moveR(j);
                    }
                    map[ycor[9]][xcor[9]] = '#';
                }
            }

            if (input[0].equals("D")) {
                for (int i = 0; i< displacement; i++) {
                    ycor[0] ++;
                    for (int j = 0 ; j < 9; j++) {
                        moveU(j);
                        moveD(j);
                        moveL(j);
                        moveR(j);
                    }
                    map[ycor[9]][xcor[9]] = '#';
                }
            }

            if (input[0].equals("L")) {
                for (int i = 0; i< displacement; i++) {
                    xcor[0] --;
                    for (int j = 0 ; j < 9; j++) {
                        moveU(j);
                        moveD(j);
                        moveL(j);
                        moveR(j);
                    }
                    map[ycor[9]][xcor[9]] = '#';
                }
            }

            if (input[0].equals("R")) {
                for (int i = 0; i< displacement; i++) {
                    xcor[0] ++;
                    for (int j = 0 ; j < 9; j++) {
                        moveU(j);
                        moveD(j);
                        moveL(j);
                        moveR(j);
                    }
                    map[ycor[9]][xcor[9]] = '#';
                }
            }   
            

            for (int i = 0; i < 10; i++) {
                System.out.println(ycor[i] + " " + xcor[i]);
            }
            System.out.println();
        }

        for (int i = 0; i < 10001; i++) {
            for (int j = 0; j < 10001; j++) {
                if (map[i][j] == '#' || map[i][j] == 's') {
                    result++;
                }
            }
        }

        for (int i = 4990; i < 5011; i++) {
            for (int j = 4990; j < 5011; j++) {
                map[5000][5000] = 's';
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println(result);
    }

    static void moveU (int i) {
        if (ycor[i + 1] - ycor[i] >= 2 ) {
            if (xcor[i ] - xcor[i  + 1] > 0) {
                ycor[i + 1]--;
                xcor[i  + 1]++;
            } 
            else if (xcor[i ] - xcor[i  + 1] < 0 ) {
                ycor[i + 1]--;
                xcor[i  + 1]--;
            }
            else {
                ycor[i + 1]--;
            }
        }
    }

    static void moveD (int i) {
        if (ycor[i] - ycor[i + 1] >= 2) {
            if (xcor[i ] - xcor[i  + 1] > 0) {
                ycor[i + 1]++;
                xcor[i  + 1]++;
            } 
            else if (xcor[i ] - xcor[i  + 1] < 0 ) {
                ycor[i + 1]++;
                xcor[i  + 1]--;
            }
            else {
                ycor[i + 1]++;
            }
        }
    
    }

    static void moveL (int i) {
        if (xcor[i + 1] - xcor[i ] >= 2) {
            if (ycor[i] - ycor[i + 1] > 0) {
                ycor[i + 1]++;
                xcor[i  + 1]--;
            } 
            else if (ycor[i] - ycor[i + 1] < 0 ) {
                ycor[i + 1]--;
                xcor[i  + 1]--;
            }
            else {
                xcor[i  + 1]--;
            }
        }
        
    }

    static void moveR (int i) {
        if (xcor[i ] - xcor[i  + 1] >= 2) {
            if (ycor[i] - ycor[i + 1] > 0) {
                ycor[i + 1]++;
                xcor[i  + 1]++;
            } 
            else if (ycor[i] - ycor[i + 1] < 0 ) {
                ycor[i + 1]--;
                xcor[i  + 1]++;
            }
            else {
                xcor[i + 1]++;
            }
        }
    }
}

