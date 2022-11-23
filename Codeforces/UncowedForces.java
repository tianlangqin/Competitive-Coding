package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class UncowedForces {
    public static void main(String[] args) {
        FastReader s = new FastReader();
        double[] time = new double[5];
        for (int i = 0; i < 5; i++) {
            time[i] = (double)s.nextInt();
        }
        
        int[] wrong = new int[5];
        for (int i = 0; i < 5; i++) {
            wrong[i] = s.nextInt();
        }

        int hs = s.nextInt();
        int hu = s.nextInt();
        double[] maxscore = {500.0, 1000.0, 1500.0, 2000.0, 2500.0};
        int result = 0;

        for (int i = 0; i < 5; i++) {
            /* 
            System.out.println((int) (0.3 * maxscore[i]) + 0.5);
            System.out.println((int) (((1.0 - (time[i]/250)) * maxscore[i] - 50 * wrong[i]) + 0.5));
            System.out.println((1.0 - (time[i]/250.0))); 
            */
            result += Math.max((int) (0.3 * maxscore[i] + 0.5), (int) (((1.0 - (time[i]/250.0)) * maxscore[i] - 50 * wrong[i]) + 0.5));
        }
        result += 100 * hs;
        result -= 50 * hu;

        System.out.println(result);
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
