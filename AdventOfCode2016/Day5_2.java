package AdventOfCode2016;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Day5_2 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        int index = 0;
        int count = 0;
        
        while (count < 10) {
            if (getMd5("uqwqemis" + index).substring(0,5).equals("00000")) {
                try {
                    int x = Integer.parseInt(getMd5("uqwqemis" + index).substring(5,6));
                    if (x >= 0 && x < 8) {
                        System.out.print(x);
                        System.out.println(getMd5("uqwqemis" + index).charAt(6));
                        count++;
                    }
                } catch (Exception e){
                    index++;
                    continue;
                }
        
            } 

            index ++;
        }
    }

    public static String getMd5(String input) {
        try {
 
            MessageDigest md = MessageDigest.getInstance("MD5");
 
            byte[] messageDigest = md.digest(input.getBytes());
 
            BigInteger no = new BigInteger(1, messageDigest);
 
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
