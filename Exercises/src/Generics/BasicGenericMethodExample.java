package Generics;

public class BasicGenericMethodExample {
    public static void main(String[] args) {

        Integer[] integers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9};
        Character[] characters = {'H', 'e', 'L', 'l', 'O', '!'};

        System.out.println("Array integerArray contains:");
        print(integers);   // pass an Integer array

        System.out.println("\nArray doubleArray contains:");
        print(doubles);   // pass a Double array

        System.out.println("\nArray characterArray contains:");
        print(characters);

    }

    // generic method printArray
    public static <E> void print(E[] input) {

        // Display array elements
        for (E element : input)
            System.out.print(element +" ");

        System.out.println();
    }

}
