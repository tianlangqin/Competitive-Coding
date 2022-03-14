import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class SwapitySwap {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("swap");
        int n = io.nextInt();
        int k = io.nextInt();
        Node head = null;
        for(int i = n; i >= 1; i--) {
            head = new Node(i,head);
        }
        int w = io.nextInt();
        int x = io.nextInt();
        int y = io.nextInt();
        int z = io.nextInt();
        for (int i = 0; i < k; i++) {
            LinkedList.reverse(head, w, x);
            LinkedList.reverse(head, y, z);
        }
        Node ptr = head;
        while (ptr != null) {
            io.println(ptr.data);
            ptr = ptr.next;
        }
        io.close();
    }

    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static class LinkedList {
        public static Node reverse(Node head, int start, int end) {
            if (head == null) {
                return null;
            }
            Node curr = head, prev = null;
            while (start > 1) {
                prev = curr;
                curr = curr.next;
                start--;
                end--;
            }
            Node con = prev, tail = curr;
            Node third = null;
            while (end > 0) {
                third = curr.next;
                curr.next = prev;
                prev = curr;
                curr = third;
                end--;
            }
            if (con != null) {
                con.next = prev;
            } else {
                head = prev;
            }
            tail.next = curr;
            return head;
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

