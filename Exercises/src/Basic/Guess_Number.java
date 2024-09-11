package Basic;

import java.util.*;
public class Guess_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int rand = random.nextInt(100);
        int i = 0;int answer = 0;
        System.out.println("---Adivinhe o Número---");
        while(i <= 10){
            if (verify(rand,answer)) {
                System.out.print("Você acertou!");
                break;
            } else if (i == 0){
                System.out.print("Informe o número: ");
                 answer = sc.nextInt();
                 i++;
            } else {
                System.out.print("Tente de Novo: ");
                answer = sc.nextInt();
                i++;
            }
        }
        if (i > 10 && !(verify(rand,answer))){
            System.out.println("Acabou suas chances, você perdeu");
        }
    }
    private static boolean verify(int rand, int answer) {
        return rand == answer;
    }
}
