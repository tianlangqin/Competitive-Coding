import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Nmonkey {
    public static void main(String[] args) {
        FastReader s = new FastReader();
        int t = s.nextInt();
        for (int i = 0; i< t; i++) {
            int n = s.nextInt();
            if (n % 3 == 0) {
                n = n /3;
                System.out.println(n + " " + n);
            }
            else if (n % 3 == 1) {
                n = n/3;
                int m = n + 1; 
                System.out.println(m + " " + n);
            }
            else {
                n = n/3;
                int m = n + 1;
                System.out.println(n + " " + m);
            }
        }
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

