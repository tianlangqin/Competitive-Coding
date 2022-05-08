import java.io.*;
import java.util.*;

public class BeatriceTeaParty {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] original = new int[n];
        int[] change = new int[n];
        for(int i = 0; i < n; i++) {
            original[i] = i + 1;
            change[i] = sc.nextInt() - 1;
        }
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            HashSet<Integer> set = new HashSet<>();
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (original[j] == 0)
                    continue;
                if (!set.contains(change[j]))
                    temp[change[j]] = original[j];
                set.add(change[j]);
            }
            original = temp;
            result = set.size();
        }
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
