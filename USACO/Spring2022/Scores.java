import java.util.Scanner;
import java.util.Stack;

public class Scores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> s = new Stack<>();
        s.push(sc.nextInt());
        for (int i = 1; i < n; i++) {
            String str = sc.next();
            if (isNumber(str)) {
                s.push(Integer.parseInt(str));
            }
            if (str.charAt(0) == 'C') {
                s.pop();
            }
            if (str.charAt(0) == 'D') {
                s.push(s.peek() * 2);
            }
            if (str.charAt(0) == '+') {
                int temp1 = s.pop();
                int temp2 = s.peek();
                s.push(temp1);
                s.push(temp1 + temp2);
            }
        }
        int result = 0;
        while(!s.isEmpty()) {
            result += s.pop();
        }
        System.out.println(result);
    }

    public static boolean isNumber(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
