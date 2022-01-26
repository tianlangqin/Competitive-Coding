package JavaHW;
import java.util.Scanner;

public class Day3HW1 {
    static int x = 1 , y = 1 , z = 0;
    static void fib(int i){
        if(i > 0){
            z = x + y;
            x = y;
            y = z;
            System.out.print(" " + z);
            fib(i - 1);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.print(x + " " + y);
        fib(i - 2);
    }
}
