package Basic;

import java.text.DecimalFormat;
import java.util.Scanner;

public class S_Value {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.print("Informe um número inteiro positivo: ");
        int n = sc.nextInt(); double s = 1;


        System.out.println("Resultado: "+df.format(calculate(n,s)));
    }
    private static double calculate(int n, double s) {
        for (int i = 2; i <= n ; i++) {
            s += (double) 1 /i;
        }
        return s;
    }
}
