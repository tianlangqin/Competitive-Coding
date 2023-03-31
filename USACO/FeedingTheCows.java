import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FeedingTheCows {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            char [] cows = br.readLine().toCharArray();
            char [] resultArr = new char[n];
            int result = 0;
            int nextH = -10000001;
            int nextG = -10000001;
            for (int i = 0; i < n; i++) {
                char currCow = cows[i];
                if (currCow == 'G') {
                    if (i > nextG + k) {
                        try {
                            resultArr[i + k] = 'G';
                            nextG = i + k;
                            result++;
                        } catch (Exception e) {
                            if (resultArr[i] == 'H') {
                                resultArr[i -1] = 'H';
                            } 
                            resultArr[i] = 'G';
                            nextG = i;
                            result++;
                        }
                        
                    }
                }
                else if (currCow == 'H') {
                    if (i > nextH + k) {
                        try {
                            resultArr[i + k] = 'H';
                            nextH = i + k;
                            result++;
                        }
                        catch (Exception e) {
                            if (resultArr[i] == 'G') {
                                resultArr[i -1] = 'G';
                            } 
                            resultArr[i] = 'H';
                            nextH = i;
                            result++;
                        }
                    }
                }

                if (resultArr[i] != 'G' && resultArr[i] != 'H') {
                    resultArr[i] = '.';
                }
            }

            System.out.println(result);
            for (int i = 0; i< n; i++) {
                System.out.print(resultArr[i]);
            }
            System.out.println();
        }
        br.close();
    }

}