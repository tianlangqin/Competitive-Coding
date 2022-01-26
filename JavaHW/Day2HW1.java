package JavaHW;
import java.util.Scanner;

public class Day2HW1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println((x + y) * (y - x + 1 ) / 2 );
    }
}
