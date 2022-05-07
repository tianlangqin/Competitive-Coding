import java.util.*;
import java.io.*;


public class Question3 {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        int width = sc.nextInt();
        int height = sc.nextInt();
        //loop through each test case
        for( int i = 0; i < times; i++){
            String[][] grid = fillMosaic(width, height);
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++){
                    System.out.print(grid[j][k]);
                }
                System.out.println();
            }
        }
    }

    static String[][] fillMosaic(int width, int height) {
        String[][] grid = new String[height][width];
        for (int i = 0; i < width; i++) {
            grid[0][i] = ".";
        }
        grid[0][(width - 1) / 2] = "#";
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String nw;
                String ne;
                try {
                    nw = grid[i - 1][j - 1];
                } catch (Exception e) {
                    nw = ".";
                }
                try {
                    ne = grid[i - 1][j + 1];
                } catch (Exception e) {
                    ne = ".";
                }
                if (ne.equals(nw) && ne.equals(grid[i - 1][j])) {
                    grid[i][j] = ".";
                }
                else {
                    grid[i][j] = "#";
                }
            }
        }
        return grid;
    }
}
