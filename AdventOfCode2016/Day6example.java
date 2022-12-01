package AdventOfCode2016;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Day6example {
  public static void main(String args[]){
    try{
      File file=new File("AdventOfCode2016/day6.txt");
      Scanner input=new Scanner(file);
      String firstColumn="";
      String secondColumn="";
      String thirdColumn="";
      String fourthColumn="";
      String fifthColumn="";
      String sixthColumn="";
      String seventhColumn="";
      String eighthColumn="";
      while(input.hasNextLine()){
        String nextLine=input.nextLine();
        String[]letters=nextLine.split("");
        firstColumn=firstColumn+letters[0];
        secondColumn=secondColumn+letters[1];
        thirdColumn=thirdColumn+letters[2];
        fourthColumn=fourthColumn+letters[3];
        fifthColumn=fifthColumn+letters[4];
        sixthColumn=sixthColumn+letters[5];
        seventhColumn=seventhColumn+letters[6];
        eighthColumn=eighthColumn+letters[7];
      }

      //column one
      char[]oneColumn = firstColumn.toCharArray(); // character array str = abcde --> {'a','b','c','d','e'}
      int[] frequency = new int[26];
      int n = firstColumn.length();

      for(int i=0; i<n; i++){
        frequency[oneColumn[i] - 'a']++;
      }
      
      //max frequency 
      int resultIndex = 0; 
      int max = 0; 
      for(int i = 0; i < 26; i++) {
        if (frequency[i] > max) {
            max  = frequency[i];
            resultIndex = i;
        }
      }
                    //   01234567890123456
      String alphabet = "abcdefghijklmnopqrstuvwxyz";
      //System.out.println(frequency[12]);
      System.out.println(alphabet.charAt(resultIndex)); //expect m;
      //System.out.println(max);

    }

  catch(FileNotFoundException ex){

  }
}
}
