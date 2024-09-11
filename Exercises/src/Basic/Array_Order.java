package Basic;

import java.util.Arrays;
import java.util.Scanner;

public class Array_Order {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double[] array = new Double[11];
        for (int i = 0; i < 11; i++) {
            System.out.print("Informe o "+(1+i)+"º número: ");
            array[i] = sc.nextDouble();
        }
        System.out.println("---Ordem Crescente---");
        System.out.println(Arrays.toString(ascendingOrder(array)));
        System.out.println();
        System.out.println("---Array Decrescente---");
        System.out.println(Arrays.toString(descendingOrder(array)));
    }
    private static Double[] descendingOrder(Double[] array) {
        for (int i = 0; i <= array.length/2 ; i++) {
            double backup = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = backup;
        }
        return array;
    }
    private static Double[] ascendingOrder(Double[] array) {
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array.length ; j++) {
                if (array[i] < array[j]) {
                   double backup = array[i];
                   array[i] = array[j];
                   array[j] = backup;
                }
            }
        }
        return array;
    }
}
