package Basic;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe um número inteiro: ");
        int number = sc.nextInt();
        System.out.println("Fatorial de "+number+": "+fatorialCalculator(number));
    }

    private static int fatorialCalculator(int number) {
        int value = 1;
        for (int i = number; i > 0  ; i--) {
            value *= i;
        }
        return value;
    }
}
