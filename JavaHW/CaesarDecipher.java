package JavaHW;
import java.util.Scanner;

public class CaesarDecipher {
    public static String decode(String code) {
        String[] arr = code.split("");
        String str = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet = str.split("");
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            for (int j = 0; j < alphabet.length; j++) {
                if (s.equals(alphabet[j])) {
                    if (j - 5 >= 0) {
                        result.append(alphabet[(j - 5) % 26]);
                    } else {
                        result.append(alphabet[(26 - (Math.abs(j - 5) % 26)) % 26]);
                    }
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        String code;
        Scanner sc = new Scanner(System.in);
        code = sc.nextLine();
        sc.close();
        System.out.println("before cipher: " + code );
        System.out.println("after cipher: " + decode(code));
    }
}
