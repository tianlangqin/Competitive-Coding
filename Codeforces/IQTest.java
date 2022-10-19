package Codeforces;
import java.util.Scanner;

public class IQTest{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        int even = 0 , odd = 0;
        for(int i = 0 ; i < n ; i++) {
            if(arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }
        if(even > odd) {
            for(int i = 0 ; i < n ; i++) {
                if(arr[i] % 2 != 0 ) {
                    System.out.println(i + 1);
                }
            }
        }
        if(odd > even) {
            for(int i = 0 ; i < n ; i++) {
                if(arr[i] % 2 == 0) {
                    System.out.println(i + 1);
                }
            }
        }
    }
}