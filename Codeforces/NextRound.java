package Codeforces;
import java.util.Scanner;

public class NextRound {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int cutoff = arr[k - 1];
        for (int i = 0 ; i < n ; i++){
            if (arr[i] >= cutoff && arr[i] > 0){
                result++;
            }
        }
        System.out.println(result);
    }
}
