import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.util.StringTokenizer;
import java.util.HashSet;
public class DistinctNumbers {
    public static void main(String[] args) {
        FastReader s = new FastReader();
        int n = s.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int temp = s.nextInt();
            if (!set.contains(temp)) {
                set.add(temp);
            }
        }
        System.out.println(set.size());
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