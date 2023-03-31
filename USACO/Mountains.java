import java.util.*;
import java.io.*;

public class Mountains {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("mountains");
        int n = io.nextInt();
        Pair[] input = new Pair[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            Pair temp = new Pair(io.nextInt(), io.nextInt());
            input[i] = temp;
        }
        for (int i = 0; i < n; i++ ) {
            for (int j = i + 1; j < n; j++) {
                Pair temp1 = input[i];
                Pair temp2 = input[j];
                if (temp1.y - ((int) Math.abs(temp1.x - temp2.x)) >= temp2.y) {
                    //System.out.println(temp1 + "\n" + temp2);
                    result++;
                }
                else if (temp2.y - ((int) Math.abs(temp2.x-temp1.x)) >= temp1.y) {
                    //System.out.println(temp1 + "\n" + temp2);
                    result++;
                }
            }
        } 
        io.println(n - result);
        io.close();
    }
    
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y ) {
            this.y = y;
            this.x = x;
        }

        public boolean equals(Pair p) {
            if (this.x == p.x && this.y == p.y) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
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
