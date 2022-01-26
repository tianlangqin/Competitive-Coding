
import java.io.*;
import java.util.StringTokenizer;

public class BovineShuffle {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("shuffle");
        int n = io.nextInt();
        int[] shuffle = new int[n];
        for (int i = 0; i < n; i++) {
            shuffle[i] = io.nextInt();
        }
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = io.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                temp[j] = id[shuffle[j]-1];
            }
            for (int j = 0; j < n; j++) {
                id[j] = temp[j];
            }
        }
        for(int i = 0; i < n; i++){
            io.println(id[i]);
        }
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

