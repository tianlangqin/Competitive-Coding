
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimizingCoins {
    
    static final int MAX = Integer.MAX_VALUE/2;
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i ++) {
            coins[i] = sc.nextInt();
        }
        
        int[] dp = new int[x + 1];
        for (int i = 0; i < x + 1; i++) {
            dp[i] = MAX;
        } 

        dp[0] = 0;  
        for (int i = 1; i <= x; i++) {
			for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i] , dp[i-coins[j]] + 1);
                }
            }
		}

        if (dp[x] == MAX) {
			dp[x] = -1;
		}

        System.out.println(dp[x]);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}