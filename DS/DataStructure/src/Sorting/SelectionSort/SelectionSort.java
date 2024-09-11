package Sorting.SelectionSort;

public class SelectionSort {
    public static void main(String[] args) {

        /*

        In selection sort, the smallest value among the unsorted elements of the array is selected in every pass and
        inserted to its appropriate position into the array. It is also the simplest algorithm. It is an in-place
        comparison sorting algorithm. In this algorithm, the array is divided into two parts, first is sorted part,
        and another one is the unsorted part. Initially, the sorted part of the array is empty, and unsorted part is
        the given array. Sorted part is placed at the left, while the unsorted part is placed at the right.

        In selection sort, the first smallest element is selected from the unsorted array and placed at the first position.
        After that second-smallest element is selected and placed in the second position. The process continues until the
        array is entirely sorted.

        The average and worst-case complexity of selection sort is O(n2), where n is the number of items. Due to this,
        it is not suitable for large data sets.

        Selection sort is generally used when:

         - A small array is to be sorted
         - Swapping cost doesn't matter
         - It is compulsory to check all elements

        Now, let's see the working of the Selection sort Algorithm.

        To understand the working of the Selection sort algorithm, let's take an unsorted array. It will be easier to
        understand the Selection sort via an example.

        Let the elements of array are:

        {12, 29, 25, 8, 32, 17, 40}

        Now, for the first position in the sorted array, the entire array is to be scanned sequentially.

        At present, 12 is stored at the first position, after searching the entire array, it is found that 8 is the
        smallest value.

        {12, 29, 25, 8, 32, 17, 40}

        So, swap 12 with 8. After the first iteration, 8 will appear at the first position in the sorted array.

        {8, 29, 25, 12, 32, 17, 40}

        For the second position, where 29 is stored presently, we again sequentially scan the rest of the items of
        unsorted array. After scanning, we find that 12 is the second-lowest element in the array that should be
        appeared at second position.

        {8, 12, 25, 29, 32, 17, 40}

        The same process is applied to the rest of the array elements. Now, we are showing a pictorial representation
        of the entire sorting process.

        {8, 12, 25, 29, 32, 17, 40}

        {8, 12, 25, 29, 32, 17, 40}

        {8, 12, 17, 29, 32, 25, 40}

        {8, 12, 17, 29, 32, 25, 40}

        {8, 12, 17, 29, 32, 25, 40}

        {8, 12, 17, 25, 32, 29, 40}

        {8, 12, 17, 25, 32, 29, 40}

        {8, 12, 17, 25, 32, 29, 40}

        {8, 12, 17, 25, 29, 32, 40}

        {8, 12, 17, 25, 28, 32, 40}

        Now, the array is completely sorted.

        Best Case -> O(n^2);
        Average Case -> O(n^2);
        Worst Case -> O(n^2);

        Space Complexity -> O(1);
        Stable -> Yes;

        */

        int[] numbers = { 91, 49, 4, 19, 10, 21 };
        System.out.println("\nBefore sorting array elements are - ");
        printArr(numbers);
        selection(numbers);
        System.out.println("\nAfter sorting array elements are - ");
        printArr(numbers);
        System.out.println();

    }

    static void selection(int[] arr) {/* function to sort an array with selection sort */
        for (int i = 0; i < arr.length - 1; i++) {
            int small = i; //minimum element in unsorted array

            for (int j = i+1; j < arr.length; j++)
                if (arr[j] < arr[small])
                    small = j;
            // Swap the minimum element with the first element
            int temp = arr[small];
            arr[small] = arr[i];
            arr[i] = temp;
        }

    }

    static void printArr(int[] arr) {/* function to print the array */
        for (int i : arr)
            System.out.print(i + " ");
    }
}
