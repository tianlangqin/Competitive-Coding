package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CrackingtheCode {
    public static void main(String[] args) {
        FastReader s = new FastReader();
        String str = s.next();
        //012345
        //12345
        //13542
        String newStr = str.substring(0, 1) + str.substring(2, 3) 
                      + str.substring(4, 5) + str.substring(3, 4)
                      + str.substring(1, 2);
        long num1 = Long.parseLong(newStr);
        //System.out.println(num1);
        //System.out.println((num1 * num1) % 100000);
        long num = ((((num1 * num1) % 100000 * num1) % 100000 * num1) * num1);
        //ystem.out.println(num);
        String bigStr = Long.toString(num);
        if (bigStr.length() - 5 < 0) {
            String result = "";
            for (int i = 0; i < 5 - bigStr.length(); i++) {
                result += "0";
            }
            System.out.println(result + bigStr);
        }
        else {
            String result = bigStr.substring(bigStr.length() - 5);
            System.out.println(result);
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
