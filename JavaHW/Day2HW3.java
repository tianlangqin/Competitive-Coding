package JavaHW;
import java.util.Scanner;

public class Day2HW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        switch (month){
            case 1:
                System.out.println("January " + day + ", " + year);
                break;
            case 2:
                System.out.println("February " + day + ", " + year);
                break;
            case 3:
                System.out.println("March " + day + ", " + year);
                break;
            case 4:
                System.out.println("April " + day + ", " + year);
                break;
            case 5:
                System.out.println("May " + day + ", " + year);
                break;
            case 6:
                System.out.println("June " + day + ", " + year);
                break;
            case 7:
                System.out.println("July " + day + ", " + year);
                break;
            case 8:
                System.out.println("August " + day + ", " + year);
                break;
            case 9:
                System.out.println("September " + day + ", " + year);
                break;
            case 10:
                System.out.println("October " + day + ", " + year);
                break;
            case 11:
                System.out.println("November " + day + ", " + year);
                break;
            case 12:
                System.out.println("December " + day + ", " + year);
                break;
        }
    }
}
