package AdventOfCode2021;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day8b {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> out = new ArrayList<String>();

        Scanner textfile = new Scanner(new File("AdventOfCode2021/day8.txt"));
        while (textfile.hasNextLine()) {
            String vals, numbs, one, four, seven;
            vals = numbs = one = four = seven = "";
            ArrayList<String> list = new ArrayList<String>();
            String line = textfile.nextLine();
            list.add(line);

            for (int i = 0; i < list.size(); i++) {
                numbs += list.get(i).substring(0, list.get(i).indexOf("|"));
                vals += list.get(i).substring(list.get(i).indexOf("|") + 1, list.get(i).length());
            }

            String[] numbers = numbs.split(" ");
            String[] values = vals.split(" ");
            String[] cleanUp = Arrays.copyOfRange(values, 1, values.length);
            int[] decode = new int[numbers.length];

            for (int i = 0; i < decode.length; i++) {
                decode[i] = -1;
            }

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i].length() == 2) {
                    one = numbers[i];
                    decode[i] = 1;
                }
                if (numbers[i].length() == 3) {
                    seven = numbers[i];
                    decode[i] = 7;
                }
                if (numbers[i].length() == 4) {
                    four = numbers[i];
                    decode[i] = 4;
                }
                if (numbers[i].length() == 7) {
                    decode[i] = 8;
                }
            }

            for (int i = 0; i < numbers.length; i++) {
                if (decode[i] == -1) {
                    if (numbers[i].length() == 5) {
                        if (numbers[i].indexOf(one.charAt(0)) != -1 && numbers[i].indexOf(one.charAt(1)) != -1 &&
                                numbers[i].indexOf(seven.charAt(0)) != -1
                                && numbers[i].indexOf(seven.charAt(1)) != -1 &&
                                numbers[i].indexOf(seven.charAt(2)) != -1) {
                            decode[i] = 3;
                        } else {
                            int match = 0;
                            for (int k = 0; k < four.length(); k++) {
                                if (numbers[i].indexOf(four.charAt(k)) != -1) {
                                    match++;
                                }
                            }
                            if (match == 2) {
                                decode[i] = 2;
                            } else {
                                decode[i] = 5;
                            }
                        }
                    }
                    if (numbers[i].length() == 6) {
                        if (numbers[i].indexOf(four.charAt(0)) != -1 && numbers[i].indexOf(four.charAt(1)) != -1 &&
                                numbers[i].indexOf(four.charAt(2)) != -1
                                && numbers[i].indexOf(four.charAt(3)) != -1) {
                            decode[i] = 9;
                        } else if (numbers[i].indexOf(one.charAt(0)) != -1 && numbers[i].indexOf(one.charAt(1)) != -1 &&
                                numbers[i].indexOf(seven.charAt(0)) != -1
                                && numbers[i].indexOf(seven.charAt(1)) != -1 &&
                                numbers[i].indexOf(seven.charAt(2)) != -1) {
                            decode[i] = 0;
                        } else {
                            decode[i] = 6;
                        }
                    }
                }
            }

            String result = "";
            for (int i = 0; i < cleanUp.length; i++) {
                for (int j = (i / 4) * 10; j < ((i / 4) + 1) * 10; j++) {
                    char[] a = cleanUp[i].toCharArray();
                    char[] b = numbers[j].toCharArray();
                    Arrays.sort(a);
                    Arrays.sort(b);
                    if (Arrays.equals(a, b)) {
                        result += decode[j];
                    }
                }
                if ((i + 1) % 4 == 0) {
                    out.add(result);
                    result = "";
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < out.size(); i++) {
            sum += Integer.parseInt(out.get(i));
        }
        System.out.println(sum);
    }
}