package JavaHW;
import java.util.Scanner;

public class LinearSearch {
    //1st line of input is the length of array
    //2nd line is the array
    //3rd line is the target we want to search
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        for (int i = 0 ; i < n ; i++){
            if (arr[i] == x ){
                System.out.println(i);
            }
        }
    }
}
