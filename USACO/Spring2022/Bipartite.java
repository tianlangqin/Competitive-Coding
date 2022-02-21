package JavaHW.Spring2022;

import java.util.*;
import java.lang.*;
import java.io.*;

class Bipartite {

    boolean isBipartite(int graph[][],int src) {
        int V = graph.length;
        int colorArr[] = new int[V];
        for (int i = 0; i < V; i++)
            colorArr[i] = -1;
        colorArr[src] = 1;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(src);
        while (q.size() != 0) {
            int x = q.poll();
            if (graph[x][x] == 1)
                return false;
            for (int i = 0; i < V; i++) {
                if (graph[x][i] == 1 && colorArr[i] == -1) {
                    colorArr[i] = 1 - colorArr[x];
                    q.add(i);
                }
                else if (graph[x][i] == 1 && colorArr[i] == colorArr[x])
                    return false;
            }
        }
        return true;
    }

    // Driver program to test above function
    public static void main (String[] args)
    {
        int G[][] = {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        Bipartite b = new Bipartite();
        if (b.isBipartite(G, 0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

