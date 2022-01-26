package JavaHW;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
    //array must be sorted
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] StrArr = str.split(" ");
        int[] arr = new int[StrArr.length];
        for(int i = 0 ; i < StrArr.length ; i++ ){
            arr[i] = Integer.parseInt(StrArr[i]);
        }
        Arrays.sort(arr);
        //sort the array
        int x = Integer.parseInt(br.readLine());
        //above is input the array and the number we want to search
        int l = 0, r = arr.length - 1;
        int exist = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // Check if x is present at mid
            if (arr[mid] == x){
                System.out.println(mid);
                exist += 1;
            }
            // If x greater, ignore left half
            if (arr[mid] < x) {
                l = mid + 1;
            }
            // If x is smaller, ignore right half
            else{
                r = mid - 1;
            }
        }
        if (exist == 0){
            System.out.println(-1);
        }
    }
}
