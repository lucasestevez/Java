package Basic;

import java.util.Scanner;

public class AverageArit_Numbers {
    public static void main(String[] args) {

        double[] array = new double[100];

        System.out.println("Média Aritimética: " + calculator(array));

    }
    private static double calculator(double[] array) {
        Scanner sc = new Scanner(System.in);
        int i; double value = 0;
        for (i = 0; i <= array.length; i++) {
            System.out.print("Digite um número: ");
            array[i] = sc.nextDouble();
            if (i == 9 || i == 19 || i == 29 || i == 39 || i == 49 || i == 59 || i == 69 || i == 79 || i == 89){
                System.out.print("Quer inserir mais números?(s ou n) ");
                char decide = sc.next().charAt(0);
                if (decide == 'n' || decide == 'N')
                    break;
            }else if (i == 99) {
                break;
            }
        }
        for (int j = 0; j < i; j++)
            value += array[j];

        return value/i;
    }
}