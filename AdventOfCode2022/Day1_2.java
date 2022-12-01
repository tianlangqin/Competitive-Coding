package AdventOfCode2022;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1_2 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day1.txt");
        Scanner sc = new Scanner(file);
        int current = 0; 
        ArrayList<Integer> result = new ArrayList<>();
        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            
            //System.out.println(temp);
            if (temp.isEmpty()) {
                result.add(current);
                current = 0;
                continue;
            }
            current += Integer.parseInt(temp);
        }
        Collections.sort(result);
        for (int i : result) {
            System.out.println(i);
        }   
        System.out.println();
        System.out.println(result.get(result.size() - 1 ) + result.get(result.size() - 2) + result.get(result.size() - 3));
        
        


    }
}