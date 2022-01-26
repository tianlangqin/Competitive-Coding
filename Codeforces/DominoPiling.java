package Codeforces;
import java.util.Scanner;

public class DominoPiling {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double m = sc.nextDouble();
        double n = sc.nextDouble();
        System.out.println((int)Math.floor(m * n /2));
    }
}
