package Sorting.BubbleSort;
/*
1. Implement the bubble sort algorithm and check its performance with an array of size 10. How many comparisons and swaps
   are performed?

2. Modify the algorithm so that it terminates early if the array is already sorted before completing all passes.

3. Compare the original version of bubble sort with the version optimized for different input sizes and evaluate the
   execution time.

4. Write code to count how many times the swap() function is called in a bubble sort run.

5. Apply bubble sort to sort an array of strings in lexicographic order.
*/

public class Exercise {
    public static void main(String[] args) {

        int[] array = {30, 70, 50, 20, 10, 90, 100, 60, 40, 80};
        System.out.println("Original Array: ");
        print(array);
        bubbleSort(array);
        System.out.println("\nSorted Array: ");
        print(array);

    }

    static void bubbleSort(int[] arr) {
        int comp = 0, exc = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                comp ++;
                if (arr[j] < arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    exc++;
                }
            }
        }
        System.out.println("\n\nComparisons: "+comp+"\nExchanges: "+exc);
    }


    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}


