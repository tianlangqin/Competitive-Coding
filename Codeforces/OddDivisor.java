package Codeforces;
import java.util.Scanner;

public class OddDivisor {
    public static boolean hasOddDivisor(long n ){
        while(n > 1){
            if(n % 2 == 0)
                n /= 2;
            else
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0 ; i < t ; i++){
            long n = sc.nextLong();
            if (hasOddDivisor(n ) == true )
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}

