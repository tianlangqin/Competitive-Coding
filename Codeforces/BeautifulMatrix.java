package Codeforces;
import java.util.Scanner;

public class BeautifulMatrix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[5][5];
        int result = 0;
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] == 1 ){
                    for(int k = 0; k < Math.abs(i - 2) + Math.abs(j - 2) ; k ++){
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
