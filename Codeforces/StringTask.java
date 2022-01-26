package Codeforces;
import java.util.Scanner;

public class StringTask {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str2 = sc.nextLine();
        String str1 = str2.toLowerCase();
        str1 = str1.replaceAll("[aeiouy]", "");
        StringBuilder str = new StringBuilder(str1);
        for(int i = 0 ; i < str.length() ; i += 2){
            str.insert(i,".");
        }
        System.out.println(str.toString());
    }
}
