package Basic;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Discounts_Store {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$#,##0.00");

        System.out.print("Informe o valor da compra: ");
        double valueS = sc.nextDouble(); double valueF;
        if(valueS < 500){
             valueF = valueS;
            System.out.println("Valor Final: "+df.format(valueF));
        }else{
            double value = valueS - 500,discount; int i = 1;
            while (!(value >= 0 && value < 100)){
                value -= 100; i++;
                if(i == 25){
                    break;
                }
            }
            discount = valueS * ((double) i /100);
            valueF = valueS - discount;
            System.out.println("Valor da compra: "+df.format(valueS));
            System.out.println("Porcentagem do Desconto: " + i + "%");
            System.out.println("Valor Final: "+df.format(valueF));
        }
    }
}
