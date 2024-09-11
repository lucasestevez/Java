package Basic;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ideal_Weight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.print("Informe seu sexo (M ou F): ");
        char sexo = sc.next().charAt(0);
        System.out.print("Informe sua altura: ");
        float alt = sc.nextFloat();

        System.out.println("Peso ideal: "+ df.format(verifyPeso(sexo, alt)));
    }

    private static Object verifyPeso(char sexo, float alt) {

        return (sexo == 'M' || sexo == 'm') ?  72.7 *alt - 58 : 62.1 * alt - 44.7;
    }
}