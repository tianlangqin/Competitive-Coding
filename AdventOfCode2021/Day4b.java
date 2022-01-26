package AdventOfCode2021;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Day4b {public static void main(String[] args) throws FileNotFoundException {
    ArrayList<String> list = new ArrayList<String>();
    Scanner file = new Scanner(new File("AdventOfCode2021/day4.txt"));
    while (file.hasNextLine()) {
        String line = file.nextLine();
        list.add(line);
    }
    ArrayList<Integer> vals = new ArrayList<Integer>();
    int[][][] sheets = new int[100][5][5];
    for (int k = 0; k < list.get(0).length() - 2; k++) {
        vals.add(Integer.parseInt(list.get(0).substring(k, list.get(0).indexOf(',', k))));
        k = list.get(0).indexOf(',', k);
    }
    vals.add(Integer.parseInt(list.get(0).substring(list.get(0).lastIndexOf(',') + 1)));
    list.remove(0);

    for (int i = 0; i < list.size(); i += 6) {
        list.remove(i);
        i--;
    }
    for (int i = 0; i < list.size(); i++) {
        for (int k = 0; k < 5; k++) {
            int val = Integer.parseInt(list.get(i).substring(k * 3, k * 3 + 2).replaceAll("\\s+", ""));
            sheets[i / 5][i % 5][k] = val;
        }
    }
    for (int a = 0; a < vals.size(); a++) {
        for (int i = 0; i < 100; i++) {
            if (sheets[i] != null) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {

                        if (sheets[i][j][k] == vals.get(a)) {
                            sheets[i][j][k] = -1;

                        }
                    }
                }
                int remaining = 0;
                int last = 0;
                for (int s = 0; s < sheets.length; s++) {
                    if (sheets[s] != null) {
                        remaining++;
                        last = s;
                    }
                }
                int rowScore = 0;
                for (int j = 0; j < 5; j++) {
                    if (sheets[i] == null) {
                        break;
                    }
                    for (int k = 0; k < 4; k++) {
                        if (sheets[i][j][k] == sheets[i][j][k + 1]) {
                            rowScore++;
                            if (rowScore == 4 && remaining == 1) {
                                answer(sheets, a, last, vals);
                            }
                            if (rowScore == 4) {
                                sheets[i] = null;
                                break;
                            }
                        } else {
                            rowScore = 0;
                        }
                    }
                }
                int colScore = 0;
                for (int k = 0; k < 5; k++) {
                    if (sheets[i] == null) {
                        break;
                    }
                    for (int j = 0; j < 4; j++) {
                        if (sheets[i][j][k] == sheets[i][j + 1][k]) {
                            colScore++;
                            if (colScore == 4 && remaining == 1) {
                                answer(sheets, a, last, vals);
                            }
                            if (colScore == 4) {
                                sheets[i] = null;
                                break;
                            }
                        } else {
                            colScore = 0;
                        }
                    }
                }

                remaining = 0;
            }
        }
    }
}

    public static void answer(int[][][] sheets, int a, int last, ArrayList<Integer> vals) {
        int sum = 0;
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (sheets[last][x][y] != -1) {
                    sum += sheets[last][x][y];
                }
            }
        }
        System.out.println(vals.get(a) * sum);
        System.exit(0);
    }
}
