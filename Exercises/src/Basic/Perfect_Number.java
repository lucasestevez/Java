package Basic;

import java.util.Scanner;

public class Perfect_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe um número inteiro: ");
        int number = sc.nextInt();

        if(!(verify(number))){
            System.out.println("O número "+number+" não é perfeito");
        }else {
            System.out.println("O número "+number+" é perfeito");
        }
    }

    private static boolean verify(int number) {
        int a = 0;
        for (int i = 1; i < number ; i++) {
            if(number % i == 0){
                a += i;
            }
        }
        return a == number;
    }
}
