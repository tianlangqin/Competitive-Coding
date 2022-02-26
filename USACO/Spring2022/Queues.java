import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Character> q = new LinkedList<>();
        HashMap<Character, Integer> count = new HashMap<>();
        String str = sc.next();
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            if (!count.containsKey(ch))
                count.put(ch, 1);
            else
                count.put(ch, count.get(ch) + 1);
            while (!q.isEmpty()) {
                if (count.get(q.peek()) > 1)
                    q.remove();
                else{
                    strB.append(q.peek());
                    break;
                }
            }
        }
        System.out.println(strB);
    }
}
