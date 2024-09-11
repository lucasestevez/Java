package Basic;

import java.util.Scanner;

public class Vowel_Consonant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char a;

        System.out.print("Informe uma letra: ");
        a = sc.next().charAt(0);

        if (a == 'a'|| a == 'e'|| a == 'i'|| a == 'o'|| a == 'u'||
            a == 'A'|| a == 'E'|| a == 'I'|| a == 'O'|| a == 'U')  {
            System.out.println(a+" é uma vogal");
        }else {
            System.out.println(a+" é uma consoante");
        }
    }
}
