package Codewars;

public class Sum {
    public static int GetSum(int a, int b){
        int result = 0;
        if (a == b){
            return a;
        }
        for(int i = Math.min(a,b) ; i <= Math.max(a,b) ; i ++){
                result += i;
        }
    return result;
    }
    public static void main(String[] args){
        System.out.println(GetSum(-1,2));
    }
}
