package Basic;

import java.util.Scanner;

public class Triangle_Class {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float x,y, z;
        System.out.print("Informe o valor primeiro lado: ");
        x = sc.nextFloat();
        System.out.print("Informe o valor segundo lado: ");
        y = sc.nextFloat();
        System.out.print("Informe o valor terceiro lado: ");
        z = sc.nextFloat();
        verifyTriangulo(x, y, z);
    }
    private static void verifyTriangulo(float x, float y, float z) {
        if(x != y && y != z && x != z){
            System.out.println("O triângulo é escaleno");
        }else if(x == y && y == z) {
            System.out.println("O triângulo é equilátero");
        }else {
            System.out.println("O triângulo é isósceles");
        }
    }
}
