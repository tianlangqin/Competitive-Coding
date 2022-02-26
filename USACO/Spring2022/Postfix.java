import java.io.IOException;
import java.util.Objects;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Postfix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();
        String str = br.readLine();
        String[] arr = str.split(" ");
        for (String i : arr) {
            if (isNumber(i)) {
                s.push(Integer.parseInt(i));
            }
            else {
                int temp1 = s.pop();
                int temp2 = s.pop();
                if (Objects.equals(i, "+")) {
                    s.push(temp1 + temp2);
                }
                if (Objects.equals(i, "-")) {
                    s.push(temp2 - temp1);
                }
                if (Objects.equals(i, "*")) {
                    s.push(temp1 * temp2);
                }
                if (Objects.equals(i, "/")) {
                    s.push(temp2 / temp1);
                }
            }
        }
        System.out.println(s.peek());
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
