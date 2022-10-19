
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BookShop {

    static final int MAX = Integer.MAX_VALUE/2;
    public static void main(String[] args) {
        FastReader s = new FastReader();
        int n = s.nextInt();
        int x = s.nextInt();
        int[] prices = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prices[i] = s.nextInt();
        }
        int[] pages = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pages[i] = s.nextInt();
        }

        int[][] dp = new int[n + 1][x + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                dp[i][j]=dp[i-1][j];
                if (j >= prices[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - prices[i- 1]] + pages[i - 1]);
                }
            }
        }

        System.out.println(dp[n][x]);
        /* 
        for (int i = 0; i < dp.length; i ++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        */
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
