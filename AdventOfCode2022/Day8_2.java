package AdventOfCode2022;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;

public class Day8_2 {
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

                int left = 0;
                int top = 0;
                int down = 0;
                int right = 0;
                
                //check left
                for (int k = j - 1; k >= 0; k-- ) {
                    left ++;
                    if (map[i][k] >= key) {
                        break;
                    }
                    
                }

                //right
                for (int k = j + 1; k < size; k++ ) {
                    right ++;
                    if (map[i][k] >= key) {
                        break;
                    }
                    
                }

                //top
                for (int k = i - 1; k >= 0; k-- ) {
                    top++;
                    if (map[k][j] >= key) {
                        break;
                    }
                }

                //bot
                for (int k = i + 1; k < size; k++ ) {
                    down++;
                    if (map[k][j] >= key) {
                        break;
                    }
                }
                
                result = Math.max(result, top * down * right * left);
                
            }
        }

        System.out.println( result);
        // for (int[] i : map) {
        //     for (int j : i) {
        //         System.out.print(j + " ") ;
        //     }
        //     System.out.println();
        // }
    }   
}