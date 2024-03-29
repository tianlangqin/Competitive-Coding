import java.util.Scanner;

public class DiceCombinations {

    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6; j++ ) {
                if (i >= j) {
                    dp[i] += dp[i-j];
                    dp[i] = dp[i] % MOD;
                }
            }
        }
        System.out.println(dp[n]);
    }
}
