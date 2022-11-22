import java.util.*;
import java.io.*;

public class ShellGame {
    public static void main(String[] args) throws IOException {

        Kattio io = new Kattio("shell");
        int n = io.nextInt();
        int[][] shell = new int[n][3];

        for (int i = 0; i < n; i ++) {
            shell[i][0] = io.nextInt() - 1;
            shell[i][1] = io.nextInt() - 1;
            shell[i][2] = io.nextInt() - 1;
        }
        
        int result = 0;
        for (int i = 0; i < 3; i ++) {
            int currLocation = i;
            int tempResult = 0;
            for (int j = 0; j < n; j ++) {
                if (shell[j][0] == currLocation) {
                    currLocation = shell[j][1];
                }
                else if (shell[j][1] == currLocation) {
                    currLocation = shell[j][0];
                }
                if (currLocation == shell[j][2]) {
                    tempResult++;
                }
                //System.out.println(currLocation);
            }
            //System.out.println(tempResult);
            result = Math.max(tempResult, result);
        }
        io.println(result);
        io.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
