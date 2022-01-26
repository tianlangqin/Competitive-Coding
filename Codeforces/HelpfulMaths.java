package Codeforces;
import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr = str.split("\\+");
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length  - 1; i++){
            System.out.print(arr[i] + "+");
        }
        System.out.print(arr[arr.length - 1]);
    }
}
