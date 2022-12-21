import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;


public class CowCollege {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] tuitions = new long[n];
        for (int i = 0; i< n; i++) {
            tuitions[i] = Long.parseLong(input[i]);
        }
        Arrays.sort(tuitions);
        
        long perTuition = 0l;
        long result = 0l;
        for (int i = 0; i < n; i++) {
            long currTuition = tuitions[i];
            long temp = currTuition * (n - i);

            if (temp > result ) {
                result = temp;
                perTuition = currTuition;
            }
        }

        System.out.println(result + " " + perTuition);
    }
}
