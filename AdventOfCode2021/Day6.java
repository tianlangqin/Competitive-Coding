package AdventOfCode2021;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Day6 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> fishies = new ArrayList<Integer>();
        long[] fish = new long[10];
        Scanner file = new Scanner(new File("AdventOfCode2021/day6.txt"));
        while (file.hasNextLine()) {
            String line = file.nextLine();
            list.add(line);
        }
        System.out.println(list.toString());
        for (int i = 0; i < list.get(0).length() - 1; i++) {
            int indexOfComma = list.get(0).indexOf(",", i);
            fishies.add(Integer.parseInt(list.get(0).substring(i, indexOfComma)));
            i = indexOfComma;
        }
        fishies.add(Integer.parseInt(list.get(0).substring(list.get(0).lastIndexOf(",") + 1, list.get(0).length())));
        int days = 0;
        for (int i : fishies) {
            fish[i]++;
        }
        while (days < 256) {
            fish[9] += fish[0];
            fish[7] += fish[0];
            fish[0] = 0;
            fish[0] = fish[1];
            fish[1] = fish[2];
            fish[2] = fish[3];
            fish[3] = fish[4];
            fish[4] = fish[5];
            fish[5] = fish[6];
            fish[6] = fish[7];
            fish[7] = fish[8];
            fish[8] = fish[9];
            fish[9] = 0;
            days++;
        }
        long total = 0;
        for(int i=0; i<fish.length; i++){
            total += fish[i];
        }
        System.out.println(total);
    }
}