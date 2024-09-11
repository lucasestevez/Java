package Basic;

import java.util.Scanner;

public class Even_Odd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe um número inteiro: ");
        int number = sc.nextInt();

        if(verify(number)){
            System.out.println("O número "+number+" é par");
        }else {
            System.out.println("O número "+number+" é ímpar");
        }
    }

    private static boolean verify(int number) {
        return number % 2 == 0;
    }
}
