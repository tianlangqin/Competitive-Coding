package PClassicFall2022;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class q7 {
    public static long timeLasted(int n, long ladders, int robberInit, int copInit, int[][] edges) {
        Graph g = new Graph();
        for (int i = 0; i < n; i++) {
            g.addNode(i);
        }

        for (int i = 0; i < n - 1; i++) {
            g.addEdge(edges[i][0], edges[i][1]);
        }

        int currPosRobber = robberInit;
        int currPosCop = copInit;
        int result = 0;
        
        while (currPosCop != currPosRobber && result < 5) {
            boolean ok = false;
            ArrayList<Integer> goodNodes = new ArrayList<Integer>();
            for(int i : g.getEdge(currPosRobber)) {
                for (int j : g.getEdge(currPosRobber)) {
                    if (i == currPosCop && !g.getEdge(j).contains(currPosCop) && j != currPosCop) {
                        goodNodes.add(j); 
                        ok = true;
                    }
                }
                
                if (i != currPosCop) {
                    ok = true;
                }
            }
            
            int max = 0;
            int tempPosRobber1 = currPosRobber;
            for(int i: goodNodes) {
                int dist = g.ShortestDistance(i, g.bfs(i), n).size();
                if (dist > max) {
                    tempPosRobber1 = i;
                    max = dist;
                }        
            }
            currPosRobber = tempPosRobber1;

            if (ok == false && ladders != 0 ) {
                int tp = 0;
                int tempPosRobber = currPosRobber;
                for (int i = 0; i < n; i++) {
                    if (i != currPosCop && i != currPosRobber) {
                        if (g.ShortestDistance(currPosCop, i, n).size() > tp) {
                            tempPosRobber = i; 
                            tp = g.ShortestDistance(currPosCop, i, n).size();
                        }
                    }
                }
                //System.out.println();
                //System.out.println(tp);
                currPosRobber = tempPosRobber;
                ladders--;
            }

            LinkedList<Integer> path = g.ShortestDistance(currPosCop,currPosRobber, n);
            currPosCop = path.get(path.size() -2);

            
            //System.out.println();
            //System.out.println(currPosCop + " " + currPosRobber);

            result++; 
        }
        
        //System.out.println();
    
        /* 
        for (int i = path.size() -1 ; i >= 0; i--) {
			    System.out.println(path.get(i) + " ");
		    }
        */

        return result;
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
        public LinkedList<Integer> ShortestDistance(int s, int dest, int n) {
            // predecessor[i] array stores predecessor of
            // i and distance array stores distance of i
            // from s
            int pred[] = new int[n];
            int dist[] = new int[n];

            
            if (BFS(s, dest, n, pred, dist) == false) {
                return new LinkedList<>();
            }
            

            // LinkedList to store path
            LinkedList<Integer> path = new LinkedList<Integer>();
            int crawl = dest;
            path.add(crawl);
            while (pred[crawl] != -1) {
                path.add(pred[crawl]);
                crawl = pred[crawl];
            }
            
            return path;
            
	    }

        public boolean BFS(int src, int dest, int n, int pred[], int dist[]) {

            LinkedList<Integer> queue = new LinkedList<Integer>();
            boolean visited[] = new boolean[n];
            for (int i = 0; i < n; i++) {
                visited[i] = false;
                dist[i] = Integer.MAX_VALUE;
                pred[i] = -1;
            }
            visited[src] = true;
            dist[src] = 0;
            queue.add(src);

            // bfs Algorithm
            while (!queue.isEmpty()) {
                int u = queue.remove();
                for (int i = 0; i < adj.get(u).size(); i++) {
                    if (visited[adj.get(u).get(i)] == false) {
                        visited[adj.get(u).get(i)] = true;
                        dist[adj.get(u).get(i)] = dist[u] + 1;
                        pred[adj.get(u).get(i)] = u;
                        queue.add(adj.get(u).get(i));

                        // stopping condition (when we find
                        // our destination)
                        if (adj.get(u).get(i) == dest)
                            return true;
                    }
                }
            }
            return false;
        }
        public int bfs(int v) {
            Queue<Integer> q = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();
            q.add(v);
            visited.add(v);
            while (q.size() != 0) {
                v = q.poll();
                Iterator<Integer> i = adj.get(v).listIterator();
                while (i.hasNext()) {
                    int temp = i.next();
                    if (!visited.contains(temp)) {
                        visited.add(temp);
                        q.add(temp);
                    }
                }
            }
            return v;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.valueOf(reader.readLine());
            long ladders = Long.valueOf(reader.readLine());
            int robbersInit = Integer.valueOf(reader.readLine());
            int copsInit = Integer.valueOf(reader.readLine());
            int[][] edges = new int[n - 1][2];
            for (int j = 0; j < n - 1; j++) {
                String[] edge = reader.readLine().split(" ");
                edges[j][0] = Integer.valueOf(edge[0]);
                edges[j][1] = Integer.valueOf(edge[1]);
            }
            long output = timeLasted(n, ladders, robbersInit, copsInit, edges);
            System.out.println(output);
        }
    }
}
