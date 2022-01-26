package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MishkaAndGame {
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
        int Mwin = 0;
        int Cwin = 0;
        for (int i = 0 ; i < n ; i ++) {
            int m = s.nextInt();
            int c = s.nextInt();
            if (m > c) {
                Mwin++;
            }
            if (m < c) {
                Cwin++;
            }
        }
        if (Mwin > Cwin){
            System.out.println("Mishka");
        }
        else if (Cwin > Mwin) {
            System.out.println("Chris");
        }
        else {
            System.out.println("Friendship is magic!^^");
        }
    }
}