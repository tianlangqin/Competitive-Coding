package Codeforces;
import java.util.Scanner;

public class PetyaAndStrings {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();
        String firstLower = first.toLowerCase();
        String secondLower = second.toLowerCase();
        if (firstLower.compareTo(secondLower) < 0){
            System.out.println(-1);
        }
        else if(firstLower.compareTo(secondLower) == 0){
            System.out.println(0);
        }
        else{
            System.out.println(1);
        }
    }
}
