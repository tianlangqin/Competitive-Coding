package AdventOfCode2021;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner file = new Scanner(new File("AdventOfCode2021/day3.txt"));
        while (file.hasNextLine()) {
            String line = file.nextLine();
            list.add(line);

        } int ones = 0;
        int zeros = 0;
        String val = "";
        for (int k = 0; k < list.get(0).length(); k++) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).charAt(k) == '1') {
                    ones++;
                } else if (list.get(i).charAt(k) == '0') {
                    zeros++;
                }
            }
            if (zeros > ones) {
                val = val + "0";
            } else {
                val = val + "1";
            }
            ones = 0;
            zeros = 0;
        }
        System.out.println((4095-Integer.valueOf(val,2))*Integer.valueOf(val,2));
        System.out.println(Integer.valueOf(loopStuff('0', '1', list), 2) * Integer.valueOf(loopStuff('1', '0', list), 2));
    }

    public static String loopStuff(char val1, char val2, ArrayList<String> list) {
            int ones2 = 0;
            int zeros2 = 0;
            char mostCom = '0';
            ArrayList<String> tempMost = new ArrayList<String>();
            for (int k = 0; k < list.get(0).length(); k++) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).charAt(k) == '1') {
                        ones2++;
                    } else if (list.get(i).charAt(k) == '0') {
                        zeros2++;
                    }
                }

                if (zeros2 > ones2) {
                    mostCom = val1;
                } else {
                    mostCom = val2;
                }
                ones2 = 0;
                zeros2 = 0;

                for (int l = 0; l < list.size(); l++) {
                    if (list.get(l).charAt(k) == mostCom) {
                        tempMost.add(list.get(l));
                    }
                }
                list = new ArrayList<String>(tempMost);
                tempMost.clear();
                if (list.size() == 1) {
                    return list.get(0);
                }
            }
            return null;
    }
}

