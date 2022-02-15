import java.util.*;
import java.io.*;
public class WhereAmI {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("USACO/whereami");
        int n = io.nextInt();
        String str = io.next();
        io.println(solve(str,n));
        io.close();
    }
    public static int solve(String str, int n) {
        HashSet<String> set = new HashSet<>();
        for (int subStrLength = 1; subStrLength <= n; subStrLength++){
            boolean ans = true;
            for (int i = 0 ; i < n - subStrLength + 1; i++) {
                String temp = str.substring(i, i + subStrLength);
                if (set.contains(temp)) {
                    ans = false;
                    break;
                }
                set.add(temp);
            }
            if (ans){
                return subStrLength;
            }
            set.clear();
        }
        return n;
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
