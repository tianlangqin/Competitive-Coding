package AdventOfCode2022;
import java.util.*;

import javax.swing.tree.ExpandVetoException;

import java.io.File;
import java.io.FileNotFoundException;

public class Day12 {
    //javac .\AdventOfCode2022\Day12.java
    //java AdventOfCode2022.Day12
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day12.txt");
        Scanner sc = new Scanner(file);
        int result = 0;
        Graph g = new Graph();
        Pair[][] map = new Pair[41][];
        Pair start = new Pair("0");
        Pair end = new Pair("0");
        int index = 0;
        while (sc.hasNextLine()) {
            String[] temp = sc.nextLine().split("");
            map[index] = new Pair[temp.length];
            for (int i = 0; i < temp.length; i++) {
                Pair tempPair = new Pair(temp[i]);
                if (tempPair.key.equals("S")) {
                    tempPair.key = "a";
                    //System.out.println(1);
                    start = tempPair;
                }
                if (tempPair.key.equals("E")) {
                    tempPair.key = "z";
                    //System.out.println(2);
                    end = tempPair;
                }
                map[index][i] = tempPair;
            }
            index++;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                
                Pair temp = map[i][j];
                g.addNode(temp);
                //System.out.println(temp.key);
                
                try {
                    Pair up = map[i - 1][j];
                    if (temp.key.charAt(0) - up.key.charAt(0) >= -1 && temp.key.charAt(0) - up.key.charAt(0) <= 2) {
                        g.addEdge(temp, up);
                    }
                } catch (Exception e) {}

                try {
                    Pair down = map[i + 1][j];
                    if (temp.key.charAt(0) - down.key.charAt(0) >= -1&&temp.key.charAt(0) - down.key.charAt(0) <= 2) {
                        g.addEdge(temp, down);
                    }
                } catch (Exception e ) {}
               
                try {
                    Pair left = map[i][j -1];
                    if (temp.key.charAt(0) - left.key.charAt(0) >= -1 && temp.key.charAt(0) - left.key.charAt(0)<= 2) {
                        g.addEdge(temp, left);
                    }
                } catch (Exception e ) {}

                try {
                    Pair right = map[i][j + 1];
                    if (temp.key.charAt(0) - right.key.charAt(0) >= -1 && temp.key.charAt(0) - right.key.charAt(0) <= 2) {
                        //System.out.println(1);
                        g.addEdge(temp, right);
                    }
                } catch (Exception e ) {}

                //System.out.println(g.getEdge(temp));
            }
        }
        
        //System.out.println(g.getEdge(start));
        //System.out.println(g.getEdge(end));
        //System.out.println(g.getEdge(test));
        //System.out.println(g.getEdge(start).get(0));
        System.out.println(g.bfs(start, end));
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

        public int bfs(Pair str, Pair e) {
            int result = 0;
            Queue<Pair> q = new LinkedList<Pair>();
            HashSet<Pair> visited = new HashSet<Pair>();
            q.add(str);
            visited.add(str);
            HashMap<Pair, Integer> distance = new HashMap<>();
            distance.put(str, 0);
            while (q.size() != 0) {
                str = q.poll();
                if (str == e) {
                    return distance.get(str);  
                }
                //System.out.println(str);
                Iterator<Pair> i = adj.get(str).listIterator();
                while (i.hasNext()) {
                    Pair temp = i.next();
                    if (!visited.contains(temp)) {
                        visited.add(temp);
                        q.add(temp);
                        distance.put(temp, distance.get(str) + 1);
                    }
                    
                }
            }
            return -1;
        }
    }

    static class Pair {
        String key; 
        Pair (String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
        public String toString () {
            return key;
        }
    }
}