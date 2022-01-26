package JavaHW;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day6HW1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] StrArr = str.split(" ");
        int[] arr = new int[StrArr.length];
        for(int i = 0 ; i < StrArr.length ; i++ ){
            arr[i] = Integer.parseInt(StrArr[i]);
        }
        String[] poker = {
                "C-2","C-3", "C-4","C-5","C-6","C-7","C-8","C-9","C-10","C-J","C-Q","C-K","C-A",
                "D-2","D-3", "D-4","D-5","D-6","D-7","D-8","D-9","D-10","D-J","D-Q","D-K","D-A",
                "H-2","H-3", "H-4","H-5","H-6","H-7","H-8","H-9","H-10","H-J","H-Q","H-K","H-A",
                "S-2","S-3", "S-4","S-5","S-6","S-7","S-8","S-9","S-10","S-J","S-Q","S-K","S-A",
        };
        for(int i = 0 ; i < arr.length ; i++){
            System.out.println(poker[arr[i]]);
        }
    }
}
