package JavaHW;

import java.util.Scanner;

public class Rice {
    public static boolean packageRice(double big, double small, double goal ) {
        if(goal % 5 > small){
            return false;
        }
        else if ((goal - small) / 5 <= big){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double big = sc.nextInt();
        double small = sc.nextInt();
        double goal = sc.nextInt();
        sc.close();
        if(packageRice(big, small, goal)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }

    }
}
