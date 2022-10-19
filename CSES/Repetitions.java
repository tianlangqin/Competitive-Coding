
import java.io.*;

public class Repetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String seq = br.readLine();
        String[] DNA = seq.split("");
        int n =1, m=1;
        String a = DNA[0];
        for (int i=1; i < DNA.length;i++){

            if (DNA[i].equals(a)){
                n++;
            }else{
                n=1;
                a=DNA[i];
            }
            if(n>m)
                m=n;
        }
        System.out.println(m);

    }
}
