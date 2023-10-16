import java.util.*;
import java.io.*;

public class ClosingTheFarm {
    public static void main(String[] args) throws IOException {
        Kattio s = new Kattio("closing");
        int n = s.nextInt();
        int m = s.nextInt();
        Graph g = new Graph();

        for (int i  = 0; i < m; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            g.addNode(a);
            g.addNode(b);
            g.addEdge(a, b);
        }

        HashSet visited = new HashSet<Integer>();
        g.dfs(1, visited); 
        if (visited.size() == g.getSize()) {
            s.println("YES");
        }
        else {
            s.println("NO");
        }

        HashSet closed = new HashSet<Integer>();

        for (int i = 0; i < n - 1; i ++) {
            visited.clear();
            int temp = s.nextInt();
            closed.add(temp);
            g.removeEdge(temp);
            int j = 1;
            while (closed.contains(j)) {
                j++;
            }
            g.dfs(j, visited);
            if (visited.size() == g.getSize() - closed.size()) {
                s.println("YES");
            }
            else {
                s.println("NO");
            }
        }
        s.nextInt();
        s.close()   ;
    }

    static class Graph {
        HashMap<Integer, ArrayList<Integer>> adj;
    
        public Graph() {
            adj = new HashMap<Integer, ArrayList<Integer>>();
        }
    
        public void addNode(int v) {
            adj.putIfAbsent(v, new ArrayList<>());
        }
    
        public void addEdge(int v1, int v2) {
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
    
        public List<Integer> getEdge(int v) {
            return adj.get(v);
        }

        public void removeEdge(int v) {
            adj.get(v).clear();
            for (ArrayList i : adj.values()) {
                i.remove(new Integer(v));
            }
        }

        public int getSize () {
            return adj.size();
        }
    
        public void dfs(int v, HashSet visited) {
            if (visited.contains(v))
                return;
            //System.out.println(v);
            visited.add(v);
            for (int i : adj.get(v)) {
                if (!visited.contains(i))
                    dfs(i, visited);
            }
        }
    
        public void bfs(int v) {
            Queue<Integer> q = new java.util.LinkedList<Integer>();
            HashSet<Integer> visited = new HashSet<>();
            q.add(v);
            visited.add(v);
            while (q.size() != 0) {
                v = q.poll();
                System.out.println(v);
                Iterator<Integer> i = adj.get(v).listIterator();
                while (i.hasNext()) {
                    int temp = i.next();
                    if (!visited.contains(temp)) {
                        visited.add(temp);
                        q.add(temp);
                    }
                }
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

