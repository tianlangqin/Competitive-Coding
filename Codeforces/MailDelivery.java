import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MailDelivery {
    public static void main(String[] args) {
        FastReader s = new FastReader();
        int n = s.nextInt();
        int m = s.nextInt();
        long[] rooms = new long[n];
        long[] letters = new long[m];
        for (int i = 0; i< n; i++) {
            if (i == 0) 
                rooms[i] = s.nextLong();
            else 
                rooms[i] = rooms[i-1] + s.nextLong();
        }
        for (int i = 0; i< m; i++) {
            letters[i] = s.nextLong();
        }

        for (int i = 0; i < m; i++) {
            long num = letters[i];
            for (int j = 0; j < n; j++) {
                if (num <= rooms[j]) {
                    int a = j+ 1; 
                    if (j != 0)
                        num -= rooms[j-1];
                    System.out.println(a + " " + num);
                    break;
                }
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

