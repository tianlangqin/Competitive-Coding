import java.util.Scanner;

public class GridPaths {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }
        
        int[][] dp = new int[n][n]; 
        sc.close(); 

        
    }    
}

