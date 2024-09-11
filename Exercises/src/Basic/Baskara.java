package Basic;

import java.util.Scanner;

public class Baskara {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o valor de A: ");
        double a = sc.nextDouble();
        if(a == 0) {
            System.out.println("Não é uma equação de 2º Grau");
        }else {
            System.out.print("Informe o valor de B: ");
            double b = sc.nextDouble();
            System.out.print("Informe o valor de C: ");
            double c = sc.nextDouble();
            double delta = b * b + 4 * a * c;

            if (delta < 0){
                System.out.println("O delta é negativo " + delta + " não possuí raízes reais");
            }else{
                 double[] x = new double[2];
                 formula(a, b, delta, x);
                System.out.println(x[0] == x[1] ? "Só existe uma raíz real" : "Exite duas raízes reais");
                System.out.println("X1: "+x[0]);
                System.out.println("X2: "+x[1]);
            }
        }
    }
    public static void formula(double a, double b, double delta, double[] x){

                 x[0] = (-b + Math.sqrt(delta)) / (2 * a);
                 x[1] = (-b - Math.sqrt(delta)) / (2 * a);

    }
}
