package PClassicFall2022;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Q7NotCleaned {
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
        
        while (currPosCop != currPosRobber) {
            boolean ok = false;
            for(int i : g.getEdge(currPosRobber)) {
                for (int j : g.getEdge(currPosRobber)) {
                    if (i == currPosCop && !g.getEdge(j).contains(currPosCop) && j != currPosCop) {
                        currPosRobber = j; 
                        ok = true;
                    }
                    
                }
                if (i != currPosCop) {
                    ok = true;
                }
            }
            
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
            System.out.println(currPosCop + " " + currPosRobber);
            


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

        public void dfs(int v, HashSet visited) {
            if (visited.contains(v))
                return;
            System.out.println(v);
            visited.add(v);
            for (int i : adj.get(v)) {
                if (!visited.contains(i))
                    dfs(i, visited);
            }
        }

        public LinkedList<Integer> ShortestDistance(int s, int dest, int n) {
            // predecessor[i] array stores predecessor of
            // i and distance array stores distance of i
            // from s
            int pred[] = new int[n];
            int dist[] = new int[n];

            
            if (BFS(s, dest, n, pred, dist) == false) {
                System.out.println("Given source and destination" +
                                            " are not connected");
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
            /* 
            // Print distance
            System.out.println("Shortest path length is: " + dist[dest]);

            // Print path
            System.out.println("Path is ::");
            for (int i = path.size() - 1; i >= 0; i--) {
                System.out.print(path.get(i) + " ");
            }
            */
	    }

        public boolean BFS(int src, int dest, int n, int pred[], int dist[]) {
            // a queue to maintain queue of vertices whose
            // adjacency list is to be scanned as per normal
            // BFS algorithm using LinkedList of Integer type
            LinkedList<Integer> queue = new LinkedList<Integer>();

            // boolean array visited[] which stores the
            // information whether ith vertex is reached
            // at least once in the Breadth first search
            boolean visited[] = new boolean[n];

            // initially all vertices are unvisited
            // so v[i] for all i is false
            // and as no path is yet constructed
            // dist[i] for all i set to infinity
            for (int i = 0; i < n; i++) {
                visited[i] = false;
                dist[i] = Integer.MAX_VALUE;
                pred[i] = -1;
            }

            // now source is first to be visited and
            // distance from source to itself should be 0
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

/*
 * 
 * // Java program to find shortest path in an undirected
// graph
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class pathUnweighted {

	// Driver Program
	public static void main(String args[])
	{
		// No of vertices
		int v = 8;

		// Adjacency list for storing which vertices are connected
		ArrayList<ArrayList<Integer>> adj =
							new ArrayList<ArrayList<Integer>>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}

		// Creating graph given in the above diagram.
		// add_edge function takes adjacency list, source
		// and destination vertex as argument and forms
		// an edge between them.
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 3);
		addEdge(adj, 1, 2);
		addEdge(adj, 3, 4);
		addEdge(adj, 3, 7);
		addEdge(adj, 4, 5);
		addEdge(adj, 4, 6);
		addEdge(adj, 4, 7);
		addEdge(adj, 5, 6);
		addEdge(adj, 6, 7);
		int source = 0, dest = 7;
		printShortestDistance(adj, source, dest, v);
	}

	// function to form edge between two vertices
	// source and dest
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j)
	{
		adj.get(i).add(j);
		adj.get(j).add(i);
	}

	// function to print the shortest distance and path
	// between source vertex and destination vertex
	private static void printShortestDistance(
					ArrayList<ArrayList<Integer>> adj,
							int s, int dest, int v)
	{
		// predecessor[i] array stores predecessor of
		// i and distance array stores distance of i
		// from s
		int pred[] = new int[v];
		int dist[] = new int[v];

		if (BFS(adj, s, dest, v, pred, dist) == false) {
			System.out.println("Given source and destination" +
										"are not connected");
			return;
		}

		// LinkedList to store path
		LinkedList<Integer> path = new LinkedList<Integer>();
		int crawl = dest;
		path.add(crawl);
		while (pred[crawl] != -1) {
			path.add(pred[crawl]);
			crawl = pred[crawl];
		}

		// Print distance
		System.out.println("Shortest path length is: " + dist[dest]);

		// Print path
		System.out.println("Path is ::");
		for (int i = path.size() - 1; i >= 0; i--) {
			System.out.print(path.get(i) + " ");
		}
	}

	// a modified version of BFS that stores predecessor
	// of each vertex in array pred
	// and its distance from source in array dist
	private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src,
								int dest, int v, int pred[], int dist[])
	{
		// a queue to maintain queue of vertices whose
		// adjacency list is to be scanned as per normal
		// BFS algorithm using LinkedList of Integer type
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// boolean array visited[] which stores the
		// information whether ith vertex is reached
		// at least once in the Breadth first search
		boolean visited[] = new boolean[v];

		// initially all vertices are unvisited
		// so v[i] for all i is false
		// and as no path is yet constructed
		// dist[i] for all i set to infinity
		for (int i = 0; i < v; i++) {
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}

		// now source is first to be visited and
		// distance from source to itself should be 0
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
}
// This code is contributed by Sahil Vaid

 */