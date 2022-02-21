import java.util.*;
import java.io.*;
import java.util.LinkedList;

public class Graph {
    HashMap<String, ArrayList<String>> adj;

    public Graph() {
        adj = new HashMap<String, ArrayList<String>>();
    }

    public void addNode(String str) {
        adj.putIfAbsent(str, new ArrayList<>());
    }

    public void addEdge(String v1,String v2) {
        adj.get(v1).add(v2);
        adj.get(v2).add(v1);
    }

    public List<String> getEdge(String v) {
        return adj.get(v);
    }

    public void dfs(String str, HashSet visited) {
        if (visited.contains(str))
            return;
        System.out.println(str);
        visited.add(str);
        for (String i : adj.get(str)) {
            if (!visited.contains(i))
                dfs(i, visited);
        }
    }

    public void bfs(String str) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(str);
        visited.add(str);
        while (q.size() != 0) {
            str = q.poll();
            System.out.println(str);
            Iterator<String> i = adj.get(str).listIterator();
            while (i.hasNext()) {
                String temp = i.next();
                if (!visited.contains(temp)) {
                    visited.add(temp);
                    q.add(temp);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Graph g = new Graph();
        HashSet<String> visited = new HashSet<>();
        int n = 5;
        int k = 6;
        g.addNode("A");
        g.addNode("B");
        g.addNode("C");
        g.addNode("D");
        g.addNode("E");
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("B", "D");
        g.addEdge("D", "A");
        g.addEdge("E", "B");
        g.addEdge("A", "E");
        g.dfs("C",visited);
        System.out.println();
        g.bfs("A");
    }
}