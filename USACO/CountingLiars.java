import java.util.Scanner;

public class CountingLiars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][2];
        for (int i = 0; i < n; i++) {
            int greater = 0;
            if (sc.next().equals("G")) {
                greater = 1;
            }
            int num = sc.nextInt();
            map[1][i] = greater;
            map[0][i] = num;
        }
        int finalResult = 0;
        for (int i = 0; i < n; i++) {
            int result = 0;
            for (int j = 0; j < n; j++) {
                if (map[0][i] != map[0][j] || map[1][i] != map[1][j]) {
                    //System.out.println(i + " " + j);
                    //System.out.println(map[0][i] + " " + map[0][j]);
                    if (map[1][i] == 1 && map[1][j] == 0 && map[0][j] < map[0][i])
                        result++;
                    if (map[1][i] == 0 && map[1][j] == 1 && map[0][j] > map[0][i])
                        result++;
                }
            }
            finalResult = Math.max(result,finalResult);
        }
        System.out.println(finalResult);
    }
}
