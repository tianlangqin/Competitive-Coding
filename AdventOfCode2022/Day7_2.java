package AdventOfCode2022;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;

public class Day7_2 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day7.txt");
        Scanner sc = new Scanner(file);
        int result = Integer.MAX_VALUE; 
        Graph g = new Graph();

        //if pair.value is -1, then it's a dir
        sc.nextLine();
        Pair root = new Pair("/", -1);
        g.addNode(root);
        Pair currDir = root;
        ArrayList<Pair> path = new ArrayList<>();
        path.add(root);

        while(sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            if (input[0].equals("$")) {
                if (input[1].equals("cd")) {
                    if (input[2].equals("..")) {
                        currDir = path.get(path.size() - 2);
                        path.remove(path.size() -1);
                    }
                    else if (input[2].equals("/")) {
                        currDir = root;
                    }
                    else {
                        Pair temp = new Pair(input[2], -1);
                        g.addNode(temp);
                        g.addEdge(currDir, temp);
                        path.add(temp);
                        currDir = temp;
                    }
                }
                else if (input[1].equals("ls")) {
                    continue;
                }
            }
            else {
                if (input[0].equals("dir")) {
                    // Pair temp = new Pair(input[1], -1);
                    // g.addNode(temp);
                    // g.addEdge(temp, currDir);
                }
                else {
                    Pair temp = new Pair(input[1], Integer.parseInt(input[0]));
                    g.addNode(temp);
                    g.addEdge(currDir, temp);
                }
            }
        }

        int total = g.sum(root);

        for (Pair i : g.adj.keySet()) {
            
            if (i.value == -1 ) {
                //System.out.println(i.key);
                //System.out.println();
                int sum = g.sum(i);
                //System.out.println(i);
                //System.out.println(sum);
                if (70000000 - total + sum >= 30000000) {
                    result = Math.min(result, sum);
                }   
            }   
        }
        System.out.println(result);
    } 

    static int calcSize (Pair dir, Graph g) {
        return 1;
    }

    static class Graph {
        HashMap<Pair, ArrayList<Pair>> adj;
    
        public Graph() {
            adj = new HashMap<Pair, ArrayList<Pair>>();
        }
    
        public void addNode(Pair p) {
            adj.putIfAbsent(p, new ArrayList<>());
        }
    
        public void addEdge(Pair v1,Pair v2) {
            adj.get(v1).add(v2);
        }
    
        public List<Pair> getEdge(Pair v) {
            return adj.get(v);
        }

        public void bfs(Pair v) {
            Queue<Pair> q = new LinkedList<>();
            HashSet<Pair> visited = new HashSet<>();
            q.add(v);
            visited.add(v);
            while (q.size() != 0) {
                v = q.poll();
                System.out.println(v);
                Iterator<Pair> i = adj.get(v).listIterator();
                while (i.hasNext()) {
                    Pair temp = i.next();
                    if (!visited.contains(temp)) {
                        visited.add(temp);
                        q.add(temp);
                    }
                }
            }
        }
        

        public int sum(Pair v) {
            int result = 0;
            Queue<Pair> q = new LinkedList<>();
            HashSet<Pair> visited = new HashSet<>();
            q.add(v);
            visited.add(v);
            while (q.size() != 0) {
                v = q.poll();
                if (v.value != -1) {
                    result += v.value;
                    //System.out.println(result);
                }
                Iterator<Pair> i = adj.get(v).listIterator();
                while (i.hasNext()) {
                    Pair temp = i.next();
                    if (!visited.contains(temp)) {
                        visited.add(temp);
                        q.add(temp);
                    }
                }
            }
            //System.out.println(result);
            //System.out.println();
            return result;
        }
    }

    static class Pair {
        String key; 
        int value; 

        Pair (String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public String toString () {
            return key;
        }
    }
}