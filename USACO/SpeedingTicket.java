
import java.io.*;
import java.util.StringTokenizer;

public class SpeedingTicket {
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("speeding");
        //input
        int n = io.nextInt();
        int[] speedLimit = new int[100];
        int m = io.nextInt();
        int[] speed = new int[100];
        int result = 0;

        int length = 0;
        int currLength = 0;
        for (int i = 0 ; i < n ; i++){
            length += io.nextInt();
            int limit = io.nextInt();
            for (int j = currLength ; j < length ; j++){
                speedLimit[j] = limit;
            }
            currLength = length;
        }
        /* for (int i = 0 ; i < 100 ; i++){
            System.out.println(speedLimit[i]);
        }
        */
        int droveLength = 0;
        int currDroveLength = 0;
        for (int i = 0 ; i < m ; i++){
            droveLength += io.nextInt();
            int currSpeed = io.nextInt();
            for (int j = currDroveLength ; j < droveLength ; j++){
                speed[j] = currSpeed;
            }
            currDroveLength = droveLength;
        }
        for (int i = 0 ; i < 100 ; i++){
            if (speed[i] > speedLimit[i]){
                result = Math.max(result, speed[i] - speedLimit[i]);
            }
        }
        io.println(result);
        io.close();
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
