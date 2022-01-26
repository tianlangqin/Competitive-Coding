import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MilkMeasurement {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("measurement");
        int n = io.nextInt();
        int[] days = new int[n];
        int[] names = new int[n];
        int[] change = new int[n];
        int Bessie = 7;
        int Elsie = 7;
        int Mildred = 7;
        int result = 0;
        int max = 7;

        for (int i = 0; i < n; i++) {
            days[i] = io.nextInt();
            String temp = io.next();
            if (temp.charAt(0) == 'B')
                names[i] = 0;
            else if (temp.charAt(0) == 'E')
                names[i] = 1;
            else
                names[i] = 2;
            change[i] = io.nextInt();
        }

        boolean[] top = new boolean[3];
        for (int i = 0; i < 3; i++){
            top[i] = true;
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < n; j++) {
                if (days[j] == i){
                    if (names[j] == 0)
                        Bessie += change[j];
                    else if (names[j] == 1)
                        Elsie += change[j];
                    else
                        Mildred += change[j];
                }
            }
            max = Math.max(Bessie,Math.max(Elsie,Mildred));
            boolean[] newTop = new boolean[3];
            if (Bessie == max)
                newTop[0] = true;
            if (Elsie == max)
                newTop[1] = true;
            if (Mildred == max)
                newTop[2] = true;
            if (Arrays.equals(top, newTop) == false)
                result++;
            top = newTop;
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
