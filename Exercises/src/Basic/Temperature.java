package Basic;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("---Conversor de Temperatura---");
        System.out.println("1 - Kelvin, 2 - Celsius, 3 - Fahrenheint");
        System.out.print("Informe em que escala está: ");
        int s = sc.nextInt();
        if(s > 0 && s < 4){
            System.out.print("Informe a temperatura: ");
            double tp = sc.nextDouble(); double[] ar = new double[3];
            tempConversion(s, tp, ar);
            System.out.println("Kelvin: "+df.format(ar[0]));
            System.out.println("Celsius: "+df.format(ar[1]));
            System.out.println("Fahrenheint: "+df.format(ar[2]));

        } else {
            System.out.println("Temperatura informada não existe");
        }
    }
    private static void tempConversion(int s, double tp, double[] ar) {
        switch (s) {
            case 1 -> {
                ar[0] = tp;
                ar[1] = tp - 273;
                ar[2] = (tp - 273) * 1.8 + 32;
            }
            case 2 -> {
                ar[0] = tp + 273;
                ar[1] = tp;
                ar[2] = tp * 1.8 + 32;
            }
            default -> {
                ar[0] = (tp - 32) * 5 / 9 + 273;
                ar[1] = (tp - 32) / 1.8;
                ar[2] = tp;
            }
        }
    }
}
