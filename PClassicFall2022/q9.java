package PClassicFall2022;
import java.io.*;

public class q9 {
    static long passcode(int[] arr, int k) {
        for (int i = arr.length - 1; i >= 0; i--) {

        }
        return 0;
    }
    
    static int star (double x, double y, double k) {
        return (int)(k * Math.floor(x/k ) + (int) y % k);
    }
    public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(reader.readLine()); //number of test cases
		
		for (int i = 0; i < t; i++) {
            
            String s1 = reader.readLine(); // read array
            String[] str1 = s1.split(" ");
            int length = Integer.valueOf(str1[0]);
            int k = Integer.valueOf(str1[1]);

            int[] arr = new int[length];
            String input = reader.readLine(); // read array
            String[] str = input.split(" ");
            for (int a = 0; a < length; a++) {
                arr[a] = Integer.valueOf(str[a]);
            }
            System.out.println(passcode(arr, k));
		}
	}
}
