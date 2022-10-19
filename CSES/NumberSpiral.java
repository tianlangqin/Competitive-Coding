
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class NumberSpiral{
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
        int t = s.nextInt();
        for (int i = 0 ; i < t ; i ++){
            long y = s.nextInt();
            long x = s.nextInt();
            long max = Math.max(y,x);
            long mid = (max * max ) - max + 1;
            long deviationX = max - x;
            long deviationY = max - y;
            long result = 0;
            if(max % 2 == 0 ){
                result = mid - deviationY + deviationX;
            }
            else{
                result = mid + deviationY - deviationX;
            }
            System.out.println(result);
        }
    }
}