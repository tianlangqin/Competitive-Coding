import java.util.Scanner;

public class Cowcert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int time = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int i = 0;
        while (arr[0] != 0) {
             i = i % n;
             if (arr[i] != 0) {
                 arr[i]--;
                 time++;
                 i++;
             }
        }
        System.out.println(time);
    }
}
