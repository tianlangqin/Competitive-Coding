import java.io.*;
import java.util.*;

public class MeiMagicRunes {
    public static void main(String[] args) {
        FastReader s = new FastReader();
        int n = s.nextInt();
        int m = s.nextInt();
        String first = "";
        for (int i = 0; i < n; i++) {
            String temp = s.next();
            if (temp.charAt(0) == 'h')
                first += "1";
            else if (temp.charAt(0) == 'e')
                first += "2";
            else
                first += "0";
        }
        String second = "";
        for (int i = 0; i < m; i++) {
            String temp = s.next();
            if (temp.charAt(0) == 'h')
                second += "1";
            else if (temp.charAt(0) == 'e')
                second += "2";
            else
                second += "0";
        }
        String result = "";
        String temp = "";
        int diff = Math.abs(first.length() - second.length());
        for (int i = 1; i <= diff; i++)
            temp += "0";
        if (first.length() < second.length())
            first = temp + first;
        else
            second = temp + second;
        int curr, carry = 0;
        for (int i = Math.max(n,m) - 1; i >= 0; i--) {
            curr = carry + (first.charAt(i) - '0') +
                    (second.charAt(i) - '0');
            carry = curr / 3;
            curr = curr % 3;
            result = (char)(curr + '0') + result;
        }
        if (carry > 0)
            result = (char)(carry + '0') + result;
        String resultTemp = "";
        for (char ch : result.toCharArray()) {
            if (ch == '2') {
                resultTemp += "earth";
            }
            else if (ch == '1') {
                resultTemp += "heaven";
            }
            else {
                resultTemp += "life";
            }
            resultTemp +=" ";
        }
        result = resultTemp.substring(0, resultTemp.length() - 1);
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
