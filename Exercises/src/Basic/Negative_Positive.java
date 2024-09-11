package Basic;

import java.util.Scanner;

public class Negative_Positive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe um número: ");
        float number = sc.nextFloat();

        if(number == 0){
            System.out.println("Número informado não é positivo nem negativo");
        }else if(verifyNumber(number)){
            System.out.println("Número "+number+" é positivo");
        }else{
            System.out.println("Número "+number+" é negativo");
        }

    }

    private static boolean verifyNumber(float number) {
        return number > 0;
    }
}
