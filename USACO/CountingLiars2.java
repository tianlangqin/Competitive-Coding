import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountingLiars2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<int[]> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int greater = 0;
            if (sc.next().equals("G")) {
                greater = 1;
            }
            int num = sc.nextInt();
            int[] arr = {num, greater};
            map.add(arr);
        }
        int finalResult = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int result = 0;
            for (int j = 0; j < n; j++) {
                if (map.get(i) != map.get(j)) {
                    if (map.get(i)[1] == 1 && map.get(j)[1] == 0 && map.get(j)[0] < map.get(i)[0])
                        result++;
                    if (map.get(i)[1] == 0 && map.get(j)[1] == 1 && map.get(j)[0] > map.get(i)[0])
                        result++;
                }
            }
            finalResult = Math.min(result,finalResult);
        }
        System.out.println(finalResult);
    }
}
