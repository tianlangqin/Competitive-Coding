import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> s = new Stack<>();
        String str = sc.next();
        char[] parentheses = str.toCharArray();
        boolean balanced = true;
        for(int i = 0; i < parentheses.length; i++) {
            if (parentheses[i] == '(') {
                s.push(parentheses[i]);
            }
            else {
                if (!s.isEmpty()) {
                    s.pop();
                }
                else {
                    balanced = false;
                }
            }
        }
        if (!s.isEmpty())
            balanced = false;
        System.out.println(balanced);
    }
}