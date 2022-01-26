package JavaHW.Spring2022;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1 {
    public static void main(String[] args) throws IOException {
        //reading from the input
        Kattio io = new Kattio("mixmilk");
        int c1 = io.nextInt();
        int m1 = io.nextInt();
        int c2 = io.nextInt();
        int m2 = io.nextInt();
        int c3 = io.nextInt();
        int m3 = io.nextInt();

        for(int i = 0 ; i < 100 ; i++){
            if (i % 3 == 0){
                int pour = Math.min(m1, c2 - m2);
                m1 -= pour;
                m2 += pour;
            }
            else if (i % 3 == 1){
                int pour = Math.min(m2, c3 - m3);
                m2 -= pour;
                m3 += pour;
            }
            else {
                int pour = Math.min(m3, c1 - m1);
                m3 -= pour;
                m1 += pour;
            }
        }
       /* slow solution
       for(int i = 0 ; i < 100 ; i ++){
            if(i % 3 == 0){
                while(m2 < c2 && m1 != 0){
                    m1--;
                    m2++;
                }
            }
            else if (i % 3 == 1){
                while(m3 < c3 && m2 != 0){
                    m2--;
                    m3++;
                }
            }
            else{
                while(m1 < c1 && m3 != 0){
                    m3--;
                    m1++;
                }
            }
        }
        */
        //writing to the output

        io.println(m1);
        io.println(m2);
        io.println(m3);
        io.close(); //tell Kattio that you are done writing your answer
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
