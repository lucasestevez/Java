package Basic;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Average_Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("--Média---");
        System.out.println("A - Média Aritimética,  P - Média Poderada,  H - Média Harmônica");
        System.out.print("Escolha qual método de cálculo quer usar: ");
        char method = sc.next().charAt(0);

        if (method == 'A' || method == 'a' || method == 'P' || method == 'p' || method == 'H' || method == 'h'){
            double[] array = new double[3];

            for (int i = 0; i < 3; i++) {
                System.out.print("Informe a "+(i+1)+"º nota: ");
                array[i] = sc.nextDouble();
            }
            if(method == 'A' || method == 'a'){
                System.out.println("Resultado: "+df.format(mediaArit(array)));
            } else if (method == 'P' || method == 'p') {

                System.out.println("Resultado: "+df.format(mediaPond(array)));
            }else {

                System.out.println("Resultado: "+df.format(mediaHar(array,mmc(array))));
            }
        }else {
            System.out.println("Método não encontrado");
        }

    }
    private static double mediaArit(double[] array) {

        return (array[0] + array[1] + array[2]) / 3;

    }

    private static double mediaPond(double[] array) {

        return (5 * array[0] + 3 * array[1] + 2 * array[2])/(5+3+2);

    }

    private static double mediaHar(double[] array, double mmc) {

        return (3 * ((mmc/array[0]) + (mmc/array[1]) + (mmc/array[2]))) / mmc;

    }

    private static double mmc(double[] array) {
        double mmcResultado = array[0];
        for(int i = 1; i < array.length; i++){
            mmcResultado = mmcResultado * (array[i] / mdc(mmcResultado, array[i]));
        }
        return mmcResultado;
    }

    public static double mdc(double a, double b){
        a=a*10; b=b*10;
        while(b != 0){
            double r = a % b;
            a = b;
            b = r;
        }
        return a/10;
    }

}
