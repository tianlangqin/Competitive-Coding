import java.util.*;

import java.io.*;

public class MixMilk {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("mixmilk");
        int[] capacity = new int[3];
        int[] milk = new int[3];

        for (int i = 0; i < 3; i++) {
            capacity[i] = io.nextInt();
            milk[i] = io.nextInt();
        }

        for (int i = 0; i < 100; i++) {
            int j = i % 3;
            int current = (j + 1) % 3;
            if (milk[j] + milk[current] <= capacity[current]) {
                milk[current] = milk[j] + milk[current];   
                milk[j] = 0; 
            }
            else {
                milk[j] = milk[j] - capacity[current] + milk[current];
                milk[current] = capacity[current];
                
            }
        }
        
        for(int i = 0; i< 3; i ++) {
            io.println(milk[i]);
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
