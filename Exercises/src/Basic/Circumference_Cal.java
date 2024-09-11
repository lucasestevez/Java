package Basic;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Circumference_Cal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat dc = new DecimalFormat("0.00");

        System.out.print("Informe o raio da circunferência: ");
        double ray = sc.nextDouble();

        double diameter = ray+ray;
        double length = 2*3.14*ray;
        double area = 3.14*ray*ray;

        System.out.println("Diâmetro: "+dc.format(diameter));
        System.out.println("Comprimento: "+dc.format(length));
        System.out.println("Área: "+dc.format(area));

    }
}
