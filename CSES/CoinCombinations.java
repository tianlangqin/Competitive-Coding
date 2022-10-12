
import java.util.*;

public class CoinCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int MOD = 1000000007;
        int n = sc.nextInt(); 
        int x = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i ++) {
            coins[i] = sc.nextInt();
        } 
        sc.close();

        int[] dp = new int[x + 1]; 
        dp[0] = 1; 
        for ( int i = 0; i <= x; i++ ) {
            for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    dp[i] += dp[i - coins[j]];
                    dp[i] = dp[i] % MOD;
                }
            }
        }
        System.out.println(dp[x]);
        
    }
}