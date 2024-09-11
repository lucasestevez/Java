package Basic;

import java.util.Scanner;

public class leap_year {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe um ano: ");
        int year = sc.nextInt();

        if(year % 4 == 0){
            System.out.println(year+" é divisível por 4, pode ser bissexto");
            if(year % 100 != 0){
                System.out.println(year+" não é divisível por 100, portanto é bissexto");
            }else {
                System.out.println(year+" é divisível por 100, pode não ter sido bissexto");
                if(year % 400 == 0){
                    System.out.println(year+" é divisível por 400, portanto é  bissexto");
                }else {
                    System.out.println(year+" não é divisível por 400, portanto não é bissexto");
                }
            }
        }else{
            System.out.println(year+" não é divisível por 4, então não é bissexto");
        }
    }
}
