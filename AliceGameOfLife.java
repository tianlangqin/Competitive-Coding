import java.io.*;
import java.util.*;
public class AliceGameOfLife {
    public static void main(String[] args) {
        FastReader s = new FastReader();
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
             arr[i] = s.nextInt();
        }
        int state = arr[0];
        int liveCount = 0;
        for (int i = 1; i < 9; i++) {
            if (arr[i] == 1)
                liveCount ++;
        }
        if (state == 1 && liveCount != 2 && liveCount != 3) {
            state = 0;
        }
        else if (state == 0 && liveCount == 3) {
            state = 1;
        }
        System.out.println(state);
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
