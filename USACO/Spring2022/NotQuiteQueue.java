import java.util.Stack;

public class NotQuiteQueue {
    static class Queue {
        static Stack<String> s1 = new Stack<>();
        static Stack<String> s2 = new Stack<>();

        static void push (String str) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
            s1.push(str);
            while (!s2.isEmpty())
                s1.push(s2.pop());
        }

        static String pop() {
            if (s1.isEmpty())
                return "Queue is empty!";
            return s1.pop();
        }

        static  String peek() {
            if (s1.isEmpty())
                return  "Queue is empty!";
            return s1.peek();
        }

        static boolean isEmpty() {
            return s1.isEmpty();
        }
    }
    public static void main(String[] args) {
    }
}
