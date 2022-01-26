package Templates;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayInput {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] StrArr = str.split(" ");
        int[] arr = new int[StrArr.length];
        for(int i = 0 ; i < StrArr.length ; i++ ){
            arr[i] = Integer.parseInt(StrArr[i]);
        }
    }
}

