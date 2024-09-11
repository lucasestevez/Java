package Basic;

import java.util.Scanner;

public class FinalNote_Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe a nota da média final: ");
        float note = sc.nextFloat();

        System.out.println("Nota: "+note+" = "+verify(note));

    }

    private static String verify(float note) {

        return (note >= 0.0 && note <= 4.9) ? "D" : (note >= 5.0 && note <= 6.9) ? "C" : (note >= 7.0 && note <= 8.9) ? "B" : "A";
    }
}
