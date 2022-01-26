package AdventOfCode2021;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner file = new Scanner(new File("AdventOfCode2021/day2.txt"));
        while (file.hasNextLine()) {
            String line = file.nextLine();
            list.add(line);
        }
        int hor = 0;
        int depth = 0;
        for (int i = 0; i < list.size(); i++) {
            int indexOfSpace = list.get(i).indexOf(' ');
            int val = Integer.parseInt(list.get(i).substring(indexOfSpace+1));
            if (list.get(i).charAt(0)=='f') {
                hor+=val;
            }
            else if (list.get(i).charAt(0)=='u') {
                depth-=val;
            }
            else if (list.get(i).charAt(0)=='d') {
                depth+=val;
            }
        }
        System.out.println(hor*depth);

        long hor2 = 0;
        long depth2 = 0;
        int aim = 0;
        for (int i = 0; i < list.size(); i++) {
            int indexOfSpace = list.get(i).indexOf(' ');
            int val = Integer.parseInt(list.get(i).substring(indexOfSpace+1));
            if (list.get(i).charAt(0)=='f') {
                hor2+=val;
                depth2+=val*aim;
            }
            else if (list.get(i).charAt(0)=='u') {
                aim-=val;
            }
            else if (list.get(i).charAt(0)=='d') {
                aim+=val;
            }
        }
        System.out.println(hor2*depth2);
    }
}

