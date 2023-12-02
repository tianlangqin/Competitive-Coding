import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2_2 {
    public static void main (String args[]) throws FileNotFoundException {
        //javac Day1.java
        //java Day1
        File file = new File("Day2.txt");
        Scanner sc = new Scanner(file);
        int result = 0;
        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] arr = input.split(":");
            String[] list = arr[1].split(";");
            int red = 0;
            int green = 0;
            int blue = 0;
            for (String i : list) {
                String [] set = i.split(",");
                System.out.println(set[0]);
                for (String j : set) {
                    String[] info = j.substring(1).split(" ");
                    System.out.println(info[0]);
                    int k = Integer.parseInt(info[0]);
                    if (info[1].equals("red")) {
                        if (k > red)
                            red = k;    
                    }
                    if (info[1].equals("green")) {
                        if (k > green)
                            green = k;
                    }
                    if (info[1].equals("blue")) {
                        if (k > blue)
                            blue = k;
                    }
                }
                
            }
            result += red * blue * green;
        }
        System.out.println(result);
    }
}

