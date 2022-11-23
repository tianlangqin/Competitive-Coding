package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ToyCars {
    public static void main(String[] args) {
        FastReader s = new FastReader();
        int n = s.nextInt();
        int[][] matrix = new int[n][n];
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = s.nextInt();
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            boolean ok = true;
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 1 || matrix[i][j] == 3) {
                    ok = false;
                }
            }
            if (ok) 
                list.add(i + 1);
        }

        System.out.println(list.size());
        if (list.size() != 0) {
            for (int i : list) {
                System.out.print(i + " ");
            } 
        }
        
    } 

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
