import java.util.*;
import java.io.*;

public class DontBeLast {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("notlast");
        HashMap<String, Integer> map = new HashMap<>();
        String[] cows = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
        for (int i = 0; i < 7; i++) {
            map.put(cows[i], 0);
        }
        int n = io.nextInt();
        for (int i = 0; i < n; i++) {
            String name = io.next();
            int milk = io.nextInt();
            map.put(name, map.get(name) + milk);
        }
        String[] min = minValues(map);
        for (String i : min){
            map.remove(i);
        }
        if (map.isEmpty()){
            io.println("Tie");
        }
        else {
            String[] secondMin = minValues(map);
            if (secondMin.length > 1) {
                io.println("Tie");
            } else
                io.println(secondMin[0]);
        }
        io.close();
    }

    public static String[] minValues (HashMap<String, Integer> map) {
        int min = Integer.MAX_VALUE;
        List<String> minKeys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                minKeys.clear();
            }
            if (entry.getValue() == min) {
                minKeys.add(entry.getKey());
            }
        }
        String[] result = new String[minKeys.size()];
        for (int i = 0; i < minKeys.size(); i++) {
            result[i] = minKeys.get(i);
        }
        return result;
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
