package AdventOfCode2021;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1 {
    public static void main (String args[]) throws FileNotFoundException {
        ArrayList<Integer> depth = new ArrayList<>();
        File file = new File("AdventOfCode2021/day1.txt");
        Scanner input = new Scanner(file);
        while(input.hasNextLine()) {
            depth.add(Integer.parseInt(input.nextLine()));
        }

        int result = 0;
        for(int i = 1; i < depth.size(); i++) {
            if(depth.get(i) > depth.get(i - 1))
                result++;
        }
        System.out.println("Part 1: " + result);

        result = 0;
        int prevSum = 0;
        for(int i = 2; i < depth.size(); i++) {
            int sum = depth.get(i - 2) + depth.get(i - 1) + depth.get(i);
            if(prevSum != 0)
                if(sum > prevSum)
                    result++;
            prevSum = sum;
            
        }
        System.out.println("Part 2: " + result);

    }

}
