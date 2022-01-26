package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Taxi1 {
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

    public static void main(String[] args) {
        FastReader s = new FastReader();
        int n = s.nextInt();
        int n1 = 0, n2 = 0, n3 = 0, n4 = 0, result = 0; //number of 1s, 2s, 3s, and 4s
        for (int i = 0; i < n; i++) {
            int a = s.nextInt();
            if (a == 4) {
                n4++;
            } else if (a == 3) {
                n3++;
            } else if (a == 2) {
                n2++;
            } else if (a == 1) {
                n1++;
            }
        }
        result += n4;
        if (n3 >= n1) {
            result += n3;
            n3 = 0;
            n1 = 0;
        } else if (n1 > n3) {
            n1 = n1 - n3;
            result += n3;
        }
        if (n2 % 2 == 0) {
            result += n2 / 2;
        } else {
            result += n2 / 2;
            n2 = 1;
        }
        if (n2 == 1 && n1 >= 2) {
            n2 = 0;
            n1 -= 2;
            result += 1;
        } else if (n2 == 1 && n1 < 2) {
            result += 1;
            n2 = 0;
            n1 = 0;
        }
        double n1b = n1;
        double x = 4;
        result += (int)Math.ceil(n1b / x);
        System.out.println(result);
    }
}
