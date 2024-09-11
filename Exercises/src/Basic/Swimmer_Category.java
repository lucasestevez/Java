package Basic;

import java.util.Scanner;

public class Swimmer_Category {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe a idade do nadador: ");
        int age = sc.nextInt();
        System.out.println("---Categoria---");
        System.out.println("Idade: "+age);
        System.out.println("Categoria: "+viewCategory(age));
    }

    private static String viewCategory(int age) {
        String category;
        if(age >= 5 && age <= 7){
            category = "Infantil A";
        }else if(age >= 8 && age <= 10){
            category = "Infantil B";
        } else if(age >= 11 && age <= 13 ){
            category = "Juvenil A";
        }else if(age >= 14 && age <= 17){
            category = "Juvenil B";
        }else{
            category = "Adulto";
        }
        return category;
    }
}
