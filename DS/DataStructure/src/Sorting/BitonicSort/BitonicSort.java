package Sorting.BitonicSort;

public class BitonicSort {
    public static void main(String[] args) {

        /*

        Bitonic sort is a parallel sorting algorithm that performs O(n^2 log n) comparisons.Although the number of
        comparisons is more than that in any other popular sorting algorithm, it performs better for the parallel
        implementation 'cause elements are compared in a predefined sequence that must not depend upon the data being sorted.

        In Bitonic sequence, elements are first arranged in increasing order, and then after some particular index,
        they start decreasing.

        Consider a sequence A[ 0 ... n-1] of n elements. First, start constructing a Bitonic sequence by using 4 elements
        of the sequence. Sort the first 2 elements in ascending order and the last 2 elements in descending order,
        concatenate this pair to form a Bitonic sequence of 4 elements. Repeat this process for the remaining pairs of the
        element until we find a Bitonic sequence.

        Let's understand the process to convert the random sequence into a bitonic sequence using an example.

        {30, 70, 40, 80, 60, 20, 10, 50}

        {30, 70, 80, 40, 20, 60, 50, 10}

        {30, 40, 80, 70, 50, 60, 20, 10}

        {30, 40, 70, 80, 60, 50, 20, 10}

        The steps used to perform the bitonic sort are listed as follows -

        In first step, we have to create the bitonic sequence from the given random sequence as we have done above.
        It is considered as the first step of the process. After this step, we will get a sequence in which the elements
        in the first half are arranged in ascending order, while the elements of the second half are arranged in
        descending order.

        Now, in the second step, we have to compare the first element of first half with the first element of second half,
        then second element of first half with the second element of second half, and so on. Here, we have to swap the
        elements if any element in the second half is found to be smaller.

        After the above step, we got all the elements in the first half smaller than all the elements in the second half.
        The compare and swap results into the two sequences of n/2 length each. Repeat the process performed in the second
        step recursively onto every sequence until we get a single sorted sequence of length n.

        {30, 40, 70, 80, 60, 50, 20, 10}

        {30, 40, 20, 10, 60, 50, 70, 80}

        {20, 10, 30, 40, 60, 50, 70, 80}

        {10, 20, 30, 40, 50, 60 ,70, 80}

        Best Case -> O(log^ 2n)
        Average Case -> O(log^2 n)
        Worst Case -> O(log^2 n)

        Space Complexity -> O(n log^2 n)
        Stable -> No
         */

        int[] arr = {20, 60, 30, 70, 50, 10, 5, 40};
        int order = 1; //It means sorting in increasing order
        System.out.print("Before sorting array elements are - \n");
        print(arr);
        sort(arr, arr.length, order);
        System.out.print("\nAfter sorting array elements are - \n");
        print(arr);

    }

    static void exchange(int[] arr, int beg, int end, int order) {
        if ((arr[beg] > arr[end] && order == 1) || (arr[beg] < arr[end] && order == 0)) {
           int  temp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = temp;
        }
    }
    static void merge(int[] arr, int beg, int length, int order) {
        if (length > 1) {
           int k = length  /2;
            for (int i = beg; i < beg + k; i++)
                exchange(arr, i, i + k, order);
            merge(arr, beg, k, order);
            merge(arr, beg + k, k, order);
        }
    }
    static void bitonicSort(int[] arr, int beg, int length, int order) {
        if (length > 1) {
            int middle = length / 2;
            bitonicSort(arr, beg, middle, 1);  // sort in ascending order
            bitonicSort(arr, beg + middle, middle, 0);  // sort in descending order
            merge(arr, beg, length, order);  //merge the sequence in ascending order
        }
    }

    /* function to call the bitonicSort() function to sort the given array in

    ascending order */
    static void sort(int[] arr, int length, int order) {
        bitonicSort(arr, 0, length, order);
    }

    static void print(int[] arr) {//function to print array elements
        for(int i : arr) {
            System.out.print(i +" ");
        }
    }

}
