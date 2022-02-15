import java.io.*;
import java.util.*;
public class CitiesAndStates {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("citystate");
        int n = io.nextInt();
        int result = 0;
        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String city = io.next();
            String state = io.next();
            if (!city.substring(0, 2).equals(state)) {
                    String key = city.substring(0, 2) + state;
                if (!map.containsKey(key))
                    map.put(key, 1);
                else
                    map.put(key, map.get(key) + 1);
            }
        }
        for (String keyA: map.keySet()) {
            String keyB = keyA.substring(2) + keyA.substring(0,2);
            if (map.containsKey(keyB)) {
                result += map.get(keyA) * map.get(keyB);
            }
        }
        io.println(result / 2);
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
