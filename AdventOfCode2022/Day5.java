package AdventOfCode2022;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;

public class Day5 {
    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("AdventOfCode2022/Day5.txt");
        Scanner sc = new Scanner(file);

        //             [C]         [N] [R]    
        // [J] [T]     [H]         [P] [L]    
        // [F] [S] [T] [B]         [M] [D]    
        // [C] [L] [J] [Z] [S]     [L] [B]    
        // [N] [Q] [G] [J] [J]     [F] [F] [R]
        // [D] [V] [B] [L] [B] [Q] [D] [M] [T]
        // [B] [Z] [Z] [T] [V] [S] [V] [S] [D]
        // [W] [P] [P] [D] [G] [P] [B] [P] [V]
        //  0   1   2   3   4   5   6   7   8
        
        //input
        Stack<Character>[] stack = new Stack[9];
        for (int i = 0; i < 9; i ++) {
            stack[i] = new Stack<>();
        }
        stack[0].push('W'); stack[1].push('P'); stack[2].push('P'); stack[3].push('D');
        stack[0].push('B'); stack[1].push('Z'); stack[2].push('Z'); stack[3].push('T');
        stack[0].push('D'); stack[1].push('V'); stack[2].push('B'); stack[3].push('L');
        stack[0].push('N'); stack[1].push('Q'); stack[2].push('G'); stack[3].push('J');
        stack[0].push('C'); stack[1].push('L'); stack[2].push('J'); stack[3].push('Z');
        stack[0].push('F'); stack[1].push('S'); stack[2].push('T'); stack[3].push('B');
        stack[0].push('J'); stack[1].push('T');                           stack[3].push('H');
                                                                                     stack[3].push('C');
        stack[4].push('G'); stack[5].push('P'); 
        stack[4].push('V'); stack[5].push('S'); 
        stack[4].push('B'); stack[5].push('Q');
        stack[4].push('J');
        stack[4].push('S');

        stack[6].push('B'); stack[7].push('P'); stack[8].push('V');
        stack[6].push('V'); stack[7].push('S'); stack[8].push('D');
        stack[6].push('D'); stack[7].push('M'); stack[8].push('T');
        stack[6].push('F'); stack[7].push('F'); stack[8].push('R');
        stack[6].push('L'); stack[7].push('B');
        stack[6].push('M'); stack[7].push('D');
        stack[6].push('P'); stack[7].push('L');
        stack[6].push('N'); stack[7].push('R');

        // for (int i = 0 ; i< stack.length; i++) {
        //     for (char ch : stack[i]) {
        //         System.out.print(ch);
        //     }
        //     System.out.println();
        // } 

        // System.out.println();

        while(sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            int nums = Integer.parseInt(input[1]);
            int from = Integer.parseInt(input[3]) - 1;
            int to = Integer.parseInt(input[5]) - 1;

            for (int i = 0; i < nums; i ++) {
                stack[to].push(stack[from].pop());
            }
            //System.out.println(1);
        }

        for (int i = 0 ; i< stack.length; i++) {
            System.out.println(stack[i].peek());
        }   
    }
}

// char[][] stack = { 
        //                  {'W', 'B', 'D', 'N', 'C', 'F', 'J', '0', '0', '0', '0', '0', '0', '0', '0'},
        //                  {'P', 'Z', 'V', 'Q', 'L', 'S', 'T', '0', '0', '0', '0', '0', '0', '0', '0'},
        //                  {'P', 'Z', 'B', 'G', 'J', 'T', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
        //                  {'D', 'T', 'L', 'J', 'Z', 'B', 'H', 'C', '0', '0', '0', '0', '0', '0', '0'},
        //                  {'G', 'V', 'B', 'J', 'S', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
        //                  {'P', 'S', 'Q', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
        //                  {'B', 'V', 'D', 'F', 'L', 'M', 'P', 'N', '0', '0', '0', '0', '0', '0', '0'},
        //                  {'P', 'S', 'M', 'F', 'B', 'D', 'L', 'R', '0', '0', '0', '0', '0', '0', '0'},
        //                  {'V', 'D', 'T', 'R', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'}
        //                  };