package Templates;

import java.util.*;
import java.io.*;

public class Graph {
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