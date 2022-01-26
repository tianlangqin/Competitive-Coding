package AdventOfCode2021;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5a {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner file = new Scanner(new File("AdventOfCode2021/day5.txt"));
        int[][] plot = new int[1000][1000];
        while (file.hasNextLine()) {
            String line = file.nextLine();
            list.add(line);
        }
        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                plot[i][j] = 0;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int indexOfComma = list.get(i).indexOf(",");
            int indexOfSpace = list.get(i).indexOf(" ");
            int x1 = Integer.parseInt(list.get(i).substring(0, indexOfComma));
            int y1 = Integer.parseInt(list.get(i).substring(indexOfComma+1, indexOfSpace));
            indexOfSpace = list.get(i).indexOf(" ", indexOfSpace+1);
            indexOfComma = list.get(i).indexOf(",", indexOfComma+1);
            int x2 = Integer.parseInt(list.get(i).substring(indexOfSpace+1, indexOfComma));
            int y2 = Integer.parseInt(list.get(i).substring(indexOfComma+1, list.get(i).length()));

            if(x1 == x2){
                if(y1<y2){
                    for(int j = y1; j<=y2; j++){
                        plot[x1][j]+=1;
                    }
                }
                else{
                    for(int j = y2; j<=y1; j++){
                        plot[x1][j]+=1;
                    }
                }
            }
            else if(y1 == y2){
                if(x1<x2){
                    for(int j = x1; j<=x2; j++){
                        plot[j][y1]+=1;
                    }
                }
                else{
                    for(int j = x2; j<=x1; j++){
                        plot[j][y1]+=1;
                    }
                }
            }
        }
        int counter = 0;
        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                if(plot[i][j] >=2){
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}