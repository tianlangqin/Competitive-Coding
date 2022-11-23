package AdventOfCode2016;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day7 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2016/day7.txt");
        Scanner sc = new Scanner(file);
        int result = 0;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();

            ArrayList<String> outside = new ArrayList<>();
            ArrayList<String> inside = new ArrayList<>();

            String temp = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '[') {
                    outside.add(temp);
                    temp = "";
                    continue;
                }
                if (str.charAt(i) == ']') {
                    inside.add(temp);
                    temp = "";
                    continue;
                }
                temp += str.substring(i, i + 1);
            }
            outside.add(temp);

            // for (String i : outside) {
            //   System.out.println(i);
            // }

            // for (String i : inside) {
            //      System.out.println(i);
            // }

            // System.out.println();

            boolean ok = false;

            for (String str1 : outside) {
                for (int i = 0; i < str1.length() - 3; i++) {
                    if (check( str1.substring(i, i +4))) 
                        ok = true;
                }
            }
            
            for (String str1 : inside) {
                for (int i =0; i < str1.length() -3; i++) {
                    if (check(str1.substring(i,i +4)))
                        ok = false;
                }
            }
            
            if(ok) 
                result++;
            //System.out.println(ok);
        }
        System.out.println(result);
    }

    static boolean check (String str) {
        //given a 4 char string, check if its abba
        String reverse = "";
        for (int i = 0; i < 4; i++) {
            char ch = str.charAt(i);
            reverse = ch + reverse;
        }

        return str.charAt(0) != str.charAt(1) && str.equals(reverse);

    }
}
