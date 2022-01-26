package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InterestingDrink {
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
    static int lower_bound(int arr[], int key) {
        // Largest value less than or equal to key
        int left = 0, right = arr.length-1;
        int pos = -1;
        while(left<=right)
        {
            int mid = left +(right-left)/2;
            if(arr[mid] <= key)
            {
                pos = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return pos;
    }
    public static void main(String[] args) {
        FastReader s = new FastReader();
        int n = s.nextInt();
        int[] price = new int[n];
        for(int i = 0 ; i < n ; i++){
            price[i] = s.nextInt();
        }
        Arrays.sort(price);
        int q = s.nextInt();
        for(int i = 0 ; i < q ; i++){
            int key = s.nextInt();
            int result = lower_bound(price,key);
            if(result == -1){
                System.out.println(0);
            }
            else {
                System.out.println(result + 1);
            }
        }
    }
}