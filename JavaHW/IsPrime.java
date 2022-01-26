package JavaHW;
import java.util.Scanner;

public class IsPrime {
    public static Boolean isPrime(Integer n){
        for(int i = 2 ; i <= n / 2 ; i ++){
            if (n % i == 0){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int num;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        sc.close();
        if (isPrime(num)){
            System.out.println(num + " is a prime number.");
        }
        else {
            System.out.println(num + " is not a prime number.");
        }
    }
}
