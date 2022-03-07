import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class TimeIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        Stack<int[]> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        Arrays.sort(intervals, (a, b ) -> Integer.compare(a[0], b[0]));
        s.push(intervals[0]);
        for (int i = 1; i < n; i++) {
            int[] top = s.peek();
            if (top[1] < intervals[i][0])
                s.push(intervals[i]);
            else if (top[1] < intervals[i][1]) {
                top[1] = intervals[i][1];
                s.pop();
                s.push(top);
            }
        }
        for (int[] i : s) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
