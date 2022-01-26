package Codewars;

public class Troll {
    public static String disemvowel(String str) {
        str = str.replaceAll("[aeiou]","");
        return str;
    }
}
