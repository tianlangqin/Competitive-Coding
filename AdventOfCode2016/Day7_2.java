package AdventOfCode2016;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day7_2 {
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
            HashSet<String> set = new HashSet<>();

            for (String str1 : outside) {
                for (int i = 0; i < str1.length() - 2; i++) { 
                    String temp1 =  str1.substring(i, i +3); 
                    if (temp1.charAt(0) == temp1.charAt(2))
                        set.add("" + temp1.charAt(1) + temp1.charAt(0) + temp1.charAt(1));
                }
            }
            
            for (String str1 : inside) {
                for (int i =0; i < str1.length() -2; i++) {
                    if (set.contains(str1.substring(i,i +3))) {
                        ok =true;
                    }
                        
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
