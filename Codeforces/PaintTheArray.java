package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PaintTheArray {
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
    public static long gcd(long a, long b) {
        if(b == 0)
            return a;
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        FastReader s = new FastReader();
        int t = s.nextInt();
        outer:for (int i = 0 ; i < t ; i++){
            int n = s.nextInt();
            long[] arr = new long[n];
            for (int j = 0 ; j < n ; j++){
                arr[j] = s.nextLong();
            }
            long a = arr[1];
            for(int j = 1; i < arr.length ; i += 2 ) {
                long greatest = gcd(a, arr[j]);
                a = greatest;
            }
            for(int j =0; j < arr.length ; i += 2 ) {
                if(arr[i] % a == 0)
                {
                    long b = arr[0];
                    for(int k = 0 ; k <arr.length ; j += 2) {
                        long greatest = gcd(b, arr[j]);
                        b = greatest;
                    }
                    if(b == 1) {
                        System.out.println("0");
                        continue outer;
                    }
                    for(int  k = 1 ; k < arr.length ; j += 2){
                        if (arr[j] % b == 0) {
                            System.out.println("0");
                            continue outer;
                        }
                    }
                    System.out.println(b);
                    continue outer;
                }
            }
            System.out.println(a);
            continue;
        }
    }
}

