package JavaHW;

import java.util.Scanner;

public class LongestSubSequence {
    public static String findLongestSubSequence (String s1, String s2, int m , int n){
        int[][] L = new int[m+1][n+1];

        // Following steps build L[m+1][n+1] in bottom up fashion. Note
        // that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (s1.charAt(i-1) == s2.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }

        int index = L[m][n];
        int temp = index;
        char[] lcs = new char[index+1];
        lcs[index] = '\u0000';
        int i = m;
        int j = n;
        while (i > 0 && j > 0)
        {

            if (s1.charAt(i-1) == s2.charAt(j-1))
            {
                lcs[index-1] = s1.charAt(i-1);
                i--;
                j--;
                index--;
            }
            else if (L[i-1][j] > L[i][j-1])
                i--;
            else
                j--;
        }
        String result = "";
        for(int k=0;k<=temp;k++)
            result += lcs[k];
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int m = s1.length();
        String s2 = sc.nextLine();
        int n = s2.length();
        sc.close();
        System.out.println("Longest common subsequence is : " + findLongestSubSequence(s1,s2,m,n));
    }
}
