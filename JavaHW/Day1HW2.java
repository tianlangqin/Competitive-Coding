package JavaHW;
import java.util.Scanner;

public class Day1HW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder(arr[i]);
            sb.reverse();
            result += sb;
            result += " ";
        }
        result.trim();
        System.out.println(result);
    }
}



