package AdventOfCode2022;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;

public class Day8 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day8.txt");
        Scanner sc = new Scanner(file);
        int size = 99;
        int result = size * size; 
        
        int[][] map = new int[size][size];

        int index = 0;
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split("");
           // System.out.println(input.length);
            for (int j = 0; j < size; j++) {
            
                map[index][j] = Integer.parseInt(input[j]);
            }
            index++;
        }

        for (int i = 0; i< size ; i++) {
            for (int j = 0 ; j < size ; j++) {
                int key = map[i][j];
                if (i == 0 || j == 0 || i == size - 1 ||j ==size -1) {
                    continue;
                }

                //visible?
                boolean left = true;
                boolean top = true;
                boolean down = true;
                boolean right = true;
                
                //check left
                for (int k = 0; k < j; k++ ) {
                    if (map[i][k] >= key) {
                        left = false;
                    }
                }

                //right
                for (int k = j + 1; k < size; k++ ) {
                    if (map[i][k] >= key) {
                        right = false;
                    }
                }

                //top
                for (int k = 0; k < i; k++ ) {
                    if (map[k][j] >= key) {
                        top = false;
                    }
                }

                //bot
                for (int k = i + 1; k < size; k++ ) {
                    if (map[k][j] >= key) {
                        down = false;
                    }
                }

                if (!left && !right && !top && !down) {
                    result --;
                    map[i][j] = -1;
                } 
            }
        }
        System.out.println( result);
        
    }   
}