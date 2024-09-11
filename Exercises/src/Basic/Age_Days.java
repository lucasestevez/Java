package Basic;

import java.util.Scanner;

public class Age_Days {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] year = new int[3];

        System.out.println("Idade expecífica");
        System.out.print("Anos: ");
        year[0] = sc.nextInt();
        System.out.print("Meses: ");
        year[1] = sc.nextInt();
        System.out.println("Dias: ");
        year[2] = sc.nextInt();
        int days = 0;
        System.out.println("Dias de vida: "+transform(year,days));
    }

    private static int transform(int[] year, int days) {

        days += year[2];
        days += year[0] * 365;
        for (int i = 1; i <= year[1]; i++) {
            if(i % 2 == 0){
                days += 31;
            }else{
                days += 30;
            }
        }
        return days;
    }
}
