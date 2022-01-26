package Codewars;
public class Maps {
    public static int[] map(int[] arr) {
        for (int i = 0 ; i < arr.length ; i++){
            arr[i] = 2 * arr[i];
        }
        return arr;
    }
}
