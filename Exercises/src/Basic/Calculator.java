package Basic;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result = 0;
        System.out.println("---Calculadora---");
        System.out.println("1 - Adição, 2 - Subtração, 3 - Multiplicação, 4 - Divisão, 5 - Radiciação, 6 - Potenciação");
        System.out.print("Informe a operação: ");
        int operation = sc.nextInt();

        System.out.println("Resultado:  " +calculator(operation, result));
    }

    private static double calculator(int operation, double result) {
        Scanner sc = new Scanner(System.in);
        if ((operation <= 0) || (operation > 6)) {
            System.out.println("Operação não encontrada");
        } else {
            if (operation <= 4) {
                System.out.print("Informe o primeiro número: ");
                double a = sc.nextDouble();
                System.out.print("Informe o segundo número: ");
                double b = sc.nextDouble();
                switch (operation) {
                    case 1 -> result = a + b;
                    case 2 -> result = a - b;
                    case 3 -> result = a * b;
                    case 4 -> result = a / b;
                }
            } else {
                System.out.print("Informe o número da base: ");
                double a = sc.nextDouble();
                System.out.print("Informe o número do índice: ");
                double b = sc.nextDouble();
                switch (operation) {
                    case 5 -> result = Math.pow(a, 1.0 / b);
                    case 6 -> result = Math.pow(a, b);
                }
            }

        }
        return result;
    }
}
