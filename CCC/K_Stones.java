package CCC;

import java.util.Scanner;

public class K_Stones{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true; 
        

    }

}