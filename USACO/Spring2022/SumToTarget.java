import java.util.HashSet;

public class SumToTarget {
    static int[] solveSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[2];
        for (int i : arr) {
            set.add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (set.contains(complement) && target / 2 != arr[i]) {
                result[0] = i;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == complement) {
                        result[1] = j;
                        return result;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int target = 17;
        int[] result = solveSum(arr,target);
        for (int i : result)
            System.out.println(i);
    }
}

