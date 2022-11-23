package AdventOfCode2016;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day3_2 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2016/day3.txt");
        Scanner input = new Scanner(file);

        int result = 0;
        while(input.hasNextLine()) {    
            int[][] matrix = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }

            for (int i = 0; i< 3; i++) {
                int a = matrix[0][i];
                int b = matrix[1][i];
                int c = matrix[2][i];
                if(a + b > c && a + c > b && b + c > a) {
                    result ++;
                }
            }
        }
        System.out.println(result);
     
        
    }
}