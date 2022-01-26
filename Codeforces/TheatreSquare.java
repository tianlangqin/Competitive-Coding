package Codeforces;
import java.util.Scanner;

public class TheatreSquare {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double n = sc.nextInt();
        double m = sc.nextInt();
        double a = sc.nextInt();
        double res = Math.ceil( n / a ) * Math.ceil( m / a);
        long result = (long)res;
        System.out.println(result);
    }
}
