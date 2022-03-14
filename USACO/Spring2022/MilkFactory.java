import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class MilkFactory {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("factory");
        Graph g = new Graph();
        int n = io.nextInt();

        for (int i = 0; i < n - 1; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            g.addNode(a);
            g.addNode(b);
            g.addEdge(a, b);
        }
        boolean haveResult = false;
        for (int i = 1; i < n; i++) {
            HashSet<String> visited = new HashSet<>();
            g.dfs(i,visited);
            if (visited.size() == n) {
                io.println(i);
                haveResult = true;
                break;
            }
        }
        if (!haveResult)
            io.println(-1);
        io.close();
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
            adj.get(v2).add(v1);
        }

        public List<Integer> getEdge(int v) {
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
