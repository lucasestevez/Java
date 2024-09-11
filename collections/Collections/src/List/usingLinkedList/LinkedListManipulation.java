package List.usingLinkedList;

import java.util.LinkedList;
import java.util.Random;

public class LinkedListManipulation {
    public static void main(String[] args) {
        Random random = new Random();
        LinkedList<Integer> integersFIFO = new LinkedList<>();

        System.out.println("FIFO: ");
        for (int i = 0; i < 10; i++) {
            integersFIFO.addFirst(random.nextInt(100));
            System.out.println(integersFIFO);
        }
        for (int i = 0; i < 10; i++) {
            integersFIFO.removeFirst();
            System.out.println(integersFIFO);
        }

        LinkedList<Integer> integersLIFO = new LinkedList<>();
        System.out.println("\nLIFO: ");
        for (int i = 0; i < 10; i++) {
            integersLIFO.addLast(random.nextInt(100));
            System.out.println(integersLIFO);
        }
        for (int i = 0; i < 10; i++) {
            integersLIFO.removeFirst();
            System.out.println(integersLIFO);
        }
    }

}
