package Sorting.CombSort;

public class CombSort {
    public static void main(String[] args) {

        /*

        It is a comparison-based sorting algorithm that is mainly an improvement in bubble sort. In bubble sort, there
        is a comparison between the adjacent elements to sort the given array. So, in bubble sort, the gap size between
        the elements that are compared is 1. Comb sort improves the bubble sort by using a gap of size more than 1.
        The gap in the comb sort starts with the larger value and then shrinks by a factor of 1.3. It means that after
        the completion of each phase, the gap is divided by the shrink factor 1.3. The iteration continues until the gap is 1.

        The shrink factor is found to be 1.3 by testing comb sort on 200,000 random lists. Comb sort works better than
        the bubble sort, but its time complexity in average case and worst case remains O(n^2).

        The process of performing the comb sort is given as follows:

        STEP 1 START

        STEP 2 Calculate the gap value if gap value == 1 goto step 5 else goto step 3

        STEP 3 Iterate over data set and compare each item with gap item then goto step 4.

        STEP 4 Swap the element if require else goto step 2

        STEP 5 Print the sorted array.

        STEP 6 STOP

        Now, let's see the working of the comb sort Algorithm.

        To understand the working of the comb sort algorithm, let's take an unsorted array. It will be easier to
        understand the comb sort via an example.

        Let the elements of array are:

          0   1   2   3   4   5   6  7
        { 49, 11, 24, 44, 29, 27, 2, 22 }

        Now, initialize

        n = 8 // size of array
        gap = n
        shrink = 1.3
        swapped = true


        First iteration

        gap = floor(gap/shrink) = floor(8/1.3) = 6

        swapped = false

               0   1   2   3   4   5   6  7
        i = 0 {49, 11, 24, 44, 29, 27, 2, 22} 49 > 2, swap
        i = 1 {2, 11, 24, 44, 29, 27, 49, 22} 11 < 22, no swap

        This iteration ends here, because at i =2, the value of i + gap = 2 + 6 = 8, and there is no element at 8th
        position of the array. So, after first iteration, the elements of array will be:

         0   1   2   3   4   5   6  7
        {2, 11, 24, 44, 29, 27, 49, 22}

        Now, move to iteration 2.


        Second iteration

        gap = floor(gap/shrink) = floor(6/1.3) = 4
        swapped = false

               0   1   2   3   4   5   6  7
        i = 0 {2, 11, 24, 44, 29, 27, 49, 22} 2 > 29, swap
        i = 1 {2, 11, 24, 44, 29, 27, 49, 22} 11 < 27, no swap
        i = 2 {2, 11, 24, 44, 29, 27, 49, 22} 24 < 49, no swap
        i = 3 {2, 11, 24, 44, 29, 27, 49, 22} 44 > 22 swap

        This iteration ends here, because at i =4, the value of i + gap = 4 + 4 = 8, and there is no element at 8th
        position of the array. So, after second iteration, the elements of array will be:

         0   1   2   3   4   5   6  7
        {2, 11, 24, 22, 29, 27, 49, 44}

        Now, move to iteration 3.


        Third iteration

        gap = floor(gap/shrink) = floor(4/1.3) = 3
        swapped = false

               0   1   2   3   4   5   6  7
        i = 0 {2, 11, 24, 22, 29, 27, 49, 44} 2 < 22, no swap
        i = 1 {2, 11, 24, 22, 29, 27, 49, 44} 11 < 29, no swap
        i = 2 {2, 11, 24, 22, 29, 27, 49, 44} 24 < 27, no swap
        i = 3 {2, 11, 24, 22, 29, 27, 49, 44} 22 < 49 no swap
        i = 4 {2, 11, 24, 22, 29, 27, 49, 44} 29 < 44 no swap

        This iteration ends here, because at i =5, the value of i + gap = 5 + 3 = 8, and there is no element at 8th
        position of the array. So, after third iteration, the elements of array will be:

         0   1   2   3   4   5   6  7
        {2, 11, 24, 22, 29, 27, 49, 44}

        Now, move to iteration 4.


        Fourth iteration

        gap = floor(gap/shrink) = floor(3/1.3) = 2
        swapped = false

               0   1   2   3   4   5   6  7
        i = 0 {2, 11, 24, 22, 29, 27, 49, 44} 2 < 24, no swap
        i = 1 {2, 11, 24, 22, 29, 27, 49, 44} 11 < 22, no swap
        i = 2 {2, 11, 24, 22, 29, 27, 49, 44} 24 < 29, no swap
        i = 3 {2, 11, 24, 22, 29, 27, 49, 44} 22 < 27, no swap
        i = 4 {2, 11, 24, 22, 29, 27, 49, 44} 29 < 49, no swap
        i = 5 {2, 11, 24, 22, 29, 27, 49, 44} 27 < 44, no swap

        This iteration ends here, because at i =6, the value of i + gap = 6 + 2 = 8, and there is no element at 8th
        position of the array. So, after fourth iteration, the elements of array will be:

         0   1   2   3   4   5   6  7
        {2, 11, 24, 22, 29, 27, 49, 44}

        Now, move to iteration 5.


        Fifth iteration

        gap = floor(gap/shrink) = floor(2/1.3) = 1
        swapped = false

               0   1   2   3   4   5   6  7
        i = 0 {2, 11, 24, 22, 29, 27, 49, 44} 2 < 11, no swap
        i = 1 {2, 11, 24, 22, 29, 27, 49, 44} 11 < 24, no swap
        i = 2 {2, 11, 24, 22, 29, 27, 49, 44} 24 > 22, swap
        i = 3 {2, 11, 22, 24, 29, 27, 49, 44} 24 < 29, no swap
        i = 4 {2, 11, 22, 24, 29, 27, 49, 44} 29 > 27, swap
        i = 5 {2, 11, 22, 24, 27, 29, 49, 44} 29 < 49, no swap
        i = 6 {2, 11, 22, 24, 27, 29, 49, 44} 49 > 44, swap

        After the fifth iteration, the sorted array is:

         0   1   2   3   4   5   6  7
        {2, 11, 22, 24, 27, 29, 44, 49}

        Hence, the iterations end here, and now the sorting is completed. Now, the final sorted array is:

         0   1   2   3   4   5   6  7
        {2, 11, 22, 24, 27, 29, 44, 49}

        Best Case -> θ(n log n);
        Average Case -> Ω(n^2/2^p) where p is a number of increments;
        Worst Case -> O(n^2).

        Space Complexity -> O(1);
        Stable -> Yes.

        */

        int[] numbers = {43, 39, 13, 42, 27, 25, 0, 4, 8};
        System.out.print("\nBefore sorting array elements are - \n");
        printArr(numbers);
        combSort(numbers, numbers.length);
        System.out.print("\nAfter sorting array elements are - \n");
        printArr(numbers);
        System.out.println();
    }

    static int updatedGap(int gap) {
        // Shrink gap by Shrink factor
        gap = (gap * 10) / 13;

        return Math.max(gap, 1);
    }

    // Function to sort array elements using Comb Sort
    static void combSort(int[] a, int n) {
        int gap = n; /* Initialize gap size equal to the size of array */
        int swapped = 1;

        while (gap != 1 || swapped == 1) {
            gap = updatedGap(gap); // find updated gap
            // Initialize swapped as false so that we can
            // check whether swap happened or not
            swapped = 0;

            for (int i = 0; i < n - gap; i++) {/* Compare all elements with current gap */

                if (a[i] > a[i + gap]) { //swap a[i] with a[i+gap]
                    int temp = a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = temp;
                    swapped = 1;
                }
            }
        }
    }

    static void printArr(int[] a) {/* function to print array elements */

        for (int j : a) System.out.print(j + " ");
    }
}


