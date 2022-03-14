import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class TheGreatRevegetation {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("revegetate");
        Graph g = new Graph();
        int n = io.nextInt();
        int m = io.nextInt();
        int[] result = new int[n];
        for (int i = 0; i < m; i++) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            g.addNode(a);
            g.addNode(b);
            g.addEdge(a, b);
        }
        go(result, g, 0);
        for (int i : result) {
            io.print(i);
        }
        io.close();
    }
    public static boolean go(int[] result, Graph g, int k) {
        if (k == result.length) return true;
        for (int i = 1; i <= 4; i++) {
            boolean ok = true;
            for (Integer j: (ArrayList<Integer>)g.getEdge(k)) {
                if (result[j] == i) {
                    ok = false;
                    break;
                }
            }
            if (!ok) continue;
            result[k] = i;
            boolean temp = go(result, g, k+1);
            if (temp) return true;
            result[k] = 0;
        }
        return false;
    }

    static class Graph {
        HashMap<Integer, ArrayList<Integer>> adj;

        public Graph() {
            adj = new HashMap<Integer, ArrayList<Integer>>();
        }

        public void addNode(int node) {
            adj.putIfAbsent(node, new ArrayList<>());
        }

        public void addEdge(int v1, int v2) {
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        public ArrayList<Integer> getEdge(int v) {
            return adj.get(v);
        }

        public void dfs(int v, HashSet visited) {
            if (visited.contains(v))
                return;
            //System.out.println(str);
            visited.add(v);
            for (int i : adj.get(v)) {
                if (!visited.contains(i))
                    dfs(i, visited);
            }
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
