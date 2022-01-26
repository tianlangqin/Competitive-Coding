package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Taxi {
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

    public static void main(String[] args) {
        //TLE :(
        FastReader s = new FastReader();
        int n = s.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            arr.add(s.nextInt());
        }
        while (arr.contains(4)){
            result++;
            arr.remove(arr.indexOf(4));
        }
        while (arr.contains(1) && arr.contains(3)){
            result++;
            arr.remove(arr.indexOf(1));
            arr.remove(arr.indexOf(3));
        }
        while (arr.contains(3)){
            result++;
            arr.remove(arr.indexOf(3));
        }
        int index = 0;
        while(arr.contains(2)){
            index += 2;
            arr.remove(arr.indexOf(2));
            if (index == 4){
                index = 0;
                result++;
            }
        }
        while(arr.contains(1)){
            index++;
            arr.remove(arr.indexOf(1));
            if (index == 4){
                index = 0;
                result++;
            }
        }
        if(index != 0){
            result++;
        }
        System.out.println(result);
    }
}