package Basic;

import java.util.Scanner;

public class PrimeNumber_OrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe um número inteiro positivo: ");
        int number = sc.nextInt();

        if(verify(number)){
            System.out.println("O número é primo");
        }else {
            System.out.println("O número não é primo");
        }
    }

    private static boolean verify(int number) {
        if (number < 2)
            return false;
        else if (number == 2)
            return true;
        else {
            int limit = (int) Math.sqrt(number);
            for (int i = 2; i < limit; i++) {
                if(number % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
}
