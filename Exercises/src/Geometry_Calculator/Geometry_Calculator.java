package Geometry_Calculator;

import java.util.Scanner;

public class Geometry_Calculator {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("1 - Flat or 2 - Solid");
        System.out.print("Enter the type of figure: ");
        int type = Integer.parseInt(sc.nextLine());
    }
}
