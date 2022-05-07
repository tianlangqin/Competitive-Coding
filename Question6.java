import java.util.*;
import java.io.*;
import java.util.LinkedList;

public class Question6 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();

        for (int i = 0; i < times; i++) {
            Graph g = new Graph();
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                g.addNode(j);
            }
            boolean ok = true;
            HashSet<Integer> connected = new HashSet<>();
            int numPref = sc.nextInt();
            for (int j = 0; j < numPref; j++) {
                int temp1 = sc.nextInt();
                int temp2 = sc.nextInt();
                if (connected.contains(temp2)) {
                    ok = false;
                }

                connected.add(temp2);
                g.addEdge(temp1, temp2);
            }
            for (int j = 0; j < n; j++) {
                Collections.sort(g.getEdge(j));
            }

            for (int j = 0; j < n; j++) {
                if (g.getEdge(j).size() != 2 && g.getEdge(j).size() != 0) {
                    ok = false;
                }

                for (int k : g.getEdge(j)) {
                    if (g.getEdge(k).contains(j)) {
                        ok = false;
                    }
                }
            }

            if (!ok) {
                System.out.println(-1);
            }

            if (ok) {
                for(int j = 0; j < n; j++) {
                    ArrayList<Integer> path = new ArrayList<>();
                    int size = g.bfs(j, path);
                    if (size == n) {
                        for (int k = 0; k < n; k++) {
                            System.out.println(path.get(k));
                        }
                    }
                }
            }
        }
    }

    static class Graph{
        HashMap<Integer, ArrayList<Integer>> adj;

        public Graph() {
            adj = new HashMap<>();
        }

        public void addNode(int v) {
            adj.putIfAbsent(v, new ArrayList<>());
        }

        public void addEdge(int v1, int v2) {
            adj.get(v1).add(v2);
        }

        public List<Integer> getEdge(int v) {
            return adj.get(v);
        }
        public int bfs(int v, ArrayList path) {
            Queue<Integer> q = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();
            q.add(v);
            visited.add(v);
            while (q.size() != 0) {
                v = q.poll();
                path.add(v);
                Iterator<Integer> i = adj.get(v).listIterator();
                while (i.hasNext()) {
                    int temp = i.next();
                    if (!visited.contains(temp)) {
                        visited.add(temp);
                        q.add(temp);
                    }
                }
            }
            return visited.size();
        }
    }
}
