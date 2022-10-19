package Codewars;

public class DRoot {
    public static int digital_root(int n) {
        int sum = 0;
        while (n > 0 || sum > 9){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}