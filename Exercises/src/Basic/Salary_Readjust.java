package Basic;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Salary_Readjust {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat dr = new DecimalFormat("0");
        double salaryAf, salaryBf = 0, increase = 0,rate = 0;
        System.out.print("Informe o salário: ");
        salaryAf = sc.nextDouble();
        if ((salaryAf <= 280.00)) {
            increase =  salaryAf * 0.20;
            salaryBf = salaryAf + increase;
            rate = 0.20*100;
        } else if ((salaryAf > 280.00 && salaryAf <= 700.00)) {
            increase = salaryAf * 0.15;
            salaryBf = salaryAf + increase;
            rate = 0.15*100;
        } else if ((salaryAf > 700.00 && salaryAf <= 1500.00)) {
            increase = salaryAf * 0.10;
            salaryBf = salaryAf + increase;
            rate = 0.10*100;
        } else if ((salaryAf > 1500.00)) {
            increase = salaryAf * 0.05;
            salaryBf = salaryAf + increase;
            rate = 0.05*100;
        }
        System.out.println("Salário Antes: "+df.format(salaryAf));
        System.out.println("Taxa: "+(dr.format(rate)+"%"));
        System.out.println("Aumento: "+df.format(increase));
        System.out.println("Salário Depois: "+df.format(salaryBf));
    }
}

