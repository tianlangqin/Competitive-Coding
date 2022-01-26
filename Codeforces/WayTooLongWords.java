package Codeforces;
import java.util.Scanner;

public class WayTooLongWords {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0 ; i < n ; i++){
            String str = sc.next();
            if (str.length() > 10) {
                String first = Character.toString(str.charAt(0));
                String last = Character.toString(str.charAt(str.length() - 1));
                String between = String.valueOf(str.length() - 2);
                System.out.println(first + between + last );
            }
            else {
                System.out.println(str);
            }
        }
    }
}
