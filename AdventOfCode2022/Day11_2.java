package AdventOfCode2022;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;

public class Day11_2 {
    //javac .\AdventOfCode2022\Day11.java
    //java AdventOfCode2022.Day11
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day11.txt");
        Scanner sc = new Scanner(file);
        long result = 0;
        int monkey = 8;
        ArrayList<ArrayList<Long>> items = new ArrayList<>();
        String[][] operation = new String[monkey][3];
        int[] test = new int[monkey];
        int[] ifTrue = new int[monkey];
        int[] ifFalse = new int[monkey];
        int[] inspections = new int[monkey];
 
        //input
        for (int i = 0; i < monkey; i ++) {
            sc.nextLine();
            String [] temp =  sc.nextLine().split(" ");
            //System.out.println(temp.length);
            //System.out.println();
            items.add(new ArrayList<>());
            for (int j = 4; j < temp.length; j ++) {
                if (j == temp.length - 1) {
                    items.get(i).add(Long.parseLong(temp[j]));
                }
                else {
                    items.get(i).add(Long.parseLong(temp[j].substring(0, temp[j].length() - 1)));
                }
                
            }
            temp = sc.nextLine().split(" ");
            operation[i][0] = temp[5];
            operation[i][1] = temp[6];
            operation[i][2] = temp[7];

            temp = sc.nextLine().split(" ");
            test[i] = Integer.parseInt(temp[5]);

            temp = sc.nextLine().split(" ");
            ifTrue[i] = Integer.parseInt(temp[9]);

            temp = sc.nextLine().split(" ");
            ifFalse[i] = Integer.parseInt(temp[9]);
            sc.nextLine();
        }
        print(items);
        print(operation);
        print(test);
        print(ifTrue);
        print(ifFalse);
        System.out.println();
        
        long mod = 1l;
        for (int i : test) {
            mod *= i;
        }
        System.out.println(mod);
        //round 
        for (int round = 0; round < 10000; round++) {
            for (int i = 0; i < monkey; i++) {
                
                for (int j = 0; j < items.get(i).size(); j++) {
                    //inspect
                    inspections[i] ++;
                    long worryLevel = items.get(i).get(j);
                    worryLevel = operate(operation[i], worryLevel) % mod; // mod = (5 * 11 * 2 * 13 * 7 * 3 * 17 * 19)
                    //System.out.println(worryLevel);
                    if (worryLevel % test[i] == 0) {
                        items.get(ifTrue[i]).add(worryLevel);
                        items.get(i).set(j, -1l);
                    } 
                    else {
                        
                        items.get(ifFalse[i]).add(worryLevel);
                        items.get(i).set(j, -1l);
                    }
                }

                while(items.get(i).contains(-1l)) {
                    items.get(i).remove(items.get(i).indexOf(-1l));
                }
            }
        }
        print(items);
        print(inspections);

        Arrays.sort(inspections);
        result = (long )inspections[inspections.length - 1] * (long)inspections[inspections.length- 2];
        System.out.println(result);
    }

    static void print (ArrayList<ArrayList<Long>> list) {
        for (ArrayList<Long> i : list) {
            for (long j : i) {
                System.out.print(j+ " ") ;
            }
            System.out.println();
        }
    }

    static long operate (String[] operation, long worryLevel) {
        if (operation[0].equals("old")) {
            if (operation[1].equals("*")) {
                if (operation[2].equals("old")) {
                    worryLevel = worryLevel * worryLevel;
                }
                else {
                    worryLevel = worryLevel * Integer.parseInt(operation[2]);
                }
            }
            if (operation[1].equals("+")) {
                if (operation[2].equals("old")) {
                    worryLevel = worryLevel + worryLevel;
                }
                else {
                    worryLevel = worryLevel + Integer.parseInt(operation[2]);
                }
            }
            if (operation[1].equals("-")) {
                if (operation[2].equals("old")) {
                    worryLevel = worryLevel - worryLevel;
                }
                else {
                    worryLevel = worryLevel - Integer.parseInt(operation[2]);
                }
            }
            if (operation[1].equals("/")) {
                if (operation[2].equals("old")) {
                    worryLevel = worryLevel / worryLevel;
                }
                else {
                    worryLevel = worryLevel / Integer.parseInt(operation[2]);
                }
            }
        }
        else {
            //Integer.parseInt(operation[0])
            if (operation[1].equals("*")) {
                if (operation[2].equals("old")) {
                    worryLevel = Integer.parseInt(operation[0]) * worryLevel;
                }
                else {
                    worryLevel = Integer.parseInt(operation[0]) * Integer.parseInt(operation[2]);
                }
            }
            if (operation[1].equals("+")) {
                if (operation[2].equals("old")) {
                    worryLevel = Integer.parseInt(operation[0]) + worryLevel;
                }
                else {
                    worryLevel = Integer.parseInt(operation[0]) + Integer.parseInt(operation[2]);
                }
            }
            if (operation[1].equals("-")) {
                if (operation[2].equals("old")) {
                    worryLevel = Integer.parseInt(operation[0]) - worryLevel;
                }
                else {
                    worryLevel = Integer.parseInt(operation[0]) - Integer.parseInt(operation[2]);
                }
            }
            if (operation[1].equals("/")) {
                if (operation[2].equals("old")) {
                    worryLevel = Integer.parseInt(operation[0]) / worryLevel;
                }
                else {
                    worryLevel = Integer.parseInt(operation[0]) / Integer.parseInt(operation[2]);
                }
            }
        }

        return worryLevel;
    }
    static void print( String[][] map) {
        for (String[] i : map) {
            for (String j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void print( int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
} 