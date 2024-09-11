package Basic;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Payroll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df =new DecimalFormat("0.00");
        double hours, value,salaryG,salaryL,discounts,ir,inss,fgts; int rateIr;

        System.out.print("Informe quantas horas trabalha por mês: ");
            hours = sc.nextDouble();
        System.out.print("Informe o valor que recebe por hora: ");
            value = sc.nextDouble();
        salaryG = hours*value;
        if(salaryG <= 900.00){
            rateIr = 0;
            ir = 0;
            inss = salaryG * 0.10;
            fgts = salaryG * 0.11;
            discounts = inss + fgts + ir;
            salaryL = salaryG - discounts;
        } else if (salaryG > 900.00 && salaryG <= 1500.00) {
            rateIr = 5;
            ir = salaryG * 0.05;
            inss = salaryG * 0.10;
            fgts = salaryG * 0.11;
            discounts = inss + fgts + ir;
            salaryL = salaryG - discounts;
        } else if (salaryG > 1500.00 && salaryG <= 2500.00) {
            rateIr = 10;
            ir = salaryG * 0.10;
            inss = salaryG * 0.10;
            fgts = salaryG * 0.11;
            discounts = inss + fgts + ir;
            salaryL = salaryG - discounts;
        } else {
            rateIr = 20;
            ir = salaryG * 0.20;
            inss = salaryG * 0.10;
            fgts = salaryG * 0.11;
            discounts = inss + fgts + ir;
            salaryL = salaryG - discounts;
        }
        System.out.println("Salário Bruto: R$"+(df.format(salaryG)));
        System.out.println("Valor pago ao IR: "+rateIr+"% = R$"+df.format(ir));
        System.out.println("Valor pago ao INSS: 10% = R$"+df.format(inss));
        System.out.println("Valor pago ao FGTS: 11% = R$"+df.format(fgts));
        System.out.println("Valor dos descontos: R$"+df.format(discounts));
        System.out.println("Salário Líquido: R$"+df.format(salaryL));
    }
}
