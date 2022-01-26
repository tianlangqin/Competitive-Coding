package JavaHW;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day1HW1 {
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String first = st.nextToken();
        String last = st.nextToken();
        System.out.println(last + " " + first);
        System.out.println(first.substring(0,1).toUpperCase() + first.substring(1) + " " + last.substring(0,1).toUpperCase() + last.substring(1));
        System.out.println(first.substring(0,1).toUpperCase() + ". " + last.substring(0,1).toUpperCase() + last.substring(1));
    }
}
