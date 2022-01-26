package JavaHW;
import java.util.Scanner;

public class Day2HW2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x % 12 == 0){
            System.out.println("monkey");
        }
        else if (x % 12 == 1){
            System.out.println("rooster");
        }
        else if (x % 12 == 2){
            System.out.println("dog");
        }
        else if (x % 12 == 3){
            System.out.println("pig");
        }
        else if (x % 12 == 4){
            System.out.println("rat");
        }
        else if (x % 12 == 5){
            System.out.println("ox");
        }
        else if (x % 12 == 6){
            System.out.println("tiger");
        }
        else if (x % 12 == 7){
            System.out.println("rabbit");
        }
        else if (x % 12 == 8){
            System.out.println("dragon");
        }
        else if (x % 12 == 9){
            System.out.println("snake");
        }
        else if (x % 12 == 10){
            System.out.println("horse");
        }
        else if (x % 12 == 11){
            System.out.println("sheep");
        }
    }
}
