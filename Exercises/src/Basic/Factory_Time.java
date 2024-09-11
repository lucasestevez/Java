package Basic;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Factory_Time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.print("Informe o tempo de duração da fábrica em segundos: ");
        int sec = sc.nextInt();
        double[] format = new double[2];
        getFormatTime(sec,format);
        System.out.println("Horas: "+df.format(format[1]));
        System.out.println("Minutos: "+df.format(format[0]));
        System.out.println("Segundos: "+sec);
    }

    private static void getFormatTime(int sec, double[] format) {
        format[0] = (double) sec / 60;
        format [1] = (double) sec / 3600;
    }
}
