package Sorting.QuickSort;

public class QuickSort {
    public static void main(String[] args) {

        /*

        Sorting is a way of arranging items in a systematic manner. Quicksort is the widely used sorting algorithm that
        makes n log n comparisons in average case for sorting an array of n elements. It is a faster and highly efficient
        sorting algorithm. This algorithm follows the divide and conquer approach. Divide and conquer is a technique of
        breaking down the algorithms into sub problems, then solving the sub problems, and combining the results back
        together to solve the original problem.

        Divide: In Divide, first pick a pivot element. After that, partition or rearrange the array into two sub-arrays
        such that each element in the left sub-array is less than or equal to the pivot element and each element in the
        right sub-array is larger than the pivot element.

        Conquer: Recursively, sort two sub arrays with Quicksort.

        Combine: Combine the already sorted array.

        Quicksort picks an element as pivot, and then it partitions the given array around the picked pivot element.
        In quick sort, a large array is divided into two arrays in which one holds values that are smaller than the
        specified value (Pivot), and another array holds the values that are greater than the pivot.

        After that, left and right sub-arrays are also partitioned using the same approach. It will continue until the
        single element remains in the sub-array.

                Quick Sort
         {  ,  ,  ,  ,  ,  ,  ,  }
                     |
                     ↓
        {  ,  ,  } {  } {  ,  ,  ,  }
                   Pivot

        Picking a good pivot is necessary for the fast implementation of quicksort. However, it is typical to determine
        a good pivot. Some of the ways of choosing a pivot are as follows:

           - Pivot can be random, i.e. select the random pivot from the given array.
           - Pivot can either be the rightmost element of the leftmost element of the given array.
           - Select median as the pivot element.


        Now, let's see the working of the Quicksort Algorithm.

        To understand the working of quick sort, let's take an unsorted array. It will make the concept more clear and
        understandable.

        Let the elements of array are:

        {24, 9, 29, 14, 19, 27}

        In the given array, we consider the leftmost element as pivot. So, in this case, a[left] = 24, a[right] = 27 and
        a[pivot] = 24.

        Since, pivot is at left, so algorithm starts from right and move towards left.

        Left
         ↓
        {24, 9, 29, 14, 19, 27}
                             ↑
                           Right

        Now, a[pivot] < a[right], so algorithm moves forward one position towards left, i.e.:

        Left
         ↓
        {24, 9, 29, 14, 19, 27}
                        ↑
                       Right

        Now, a[left] = 24, a[right] = 19, and a[pivot] = 24.

        Because, a[pivot] > a[right], so, algorithm will swap a[pivot] with a[right], and pivot moves to right, as:

        Left           Pivot
         ↓              ↓
        {24, 9, 29, 14, 19, 27}
                        ↑
                       Right

        Now, a[left] = 19, a[right] = 24, and a[pivot] = 24. Since, pivot is at right, so algorithm starts from left
        and moves to right.

        As a[pivot] > a[left], so algorithm moves one position to right as:

                       Pivot
                        ↓
        {19, 9, 29, 14, 24, 27}
             ↑          ↑
           Left        Right

        Now, a[left] = 9, a[right] = 24, and a[pivot] = 24. As a[pivot] > a[left], so algorithm moves one position to
        right as:

                      Pivot
                        ↓
        {19, 9, 29, 14, 24, 27}
                ↑       ↑
              Left     Right

        Now, a[left] = 29, a[right] = 24, and a[pivot] = 24. As a[pivot] < a[left], so, swap a[pivot] and a[left], now pivot
        is at left, i.e.:

              Pivot
                ↓
        {19, 9, 24, 14, 29, 27}
                ↑       ↑
              Left     Right

        Since, pivot is at left, so algorithm starts from right, and move to left. Now, a[left] = 24, a[right] = 29,
        and a[pivot] = 24. As a[pivot] < a[right], so algorithm moves one position to left, as:

              Pivot
                ↓
        {19, 9, 24, 14, 29, 27}
                ↑   ↑
              Left  Right

        Now, a[pivot] = 24, a[left] = 24, and a[right] = 14. As a[pivot] > a[right], so, swap a[pivot] and a[right],
        now pivot is at right, i.e.:

                  Pivot
                    ↓
        {19, 9, 14, 24, 29, 27}
                ↑   ↑
              Left  Right

        Now, a[pivot] = 24, a[left] = 14, and a[right] = 24. Pivot is at right, so the algorithm starts from left and
        move to right.

                  Pivot
                    ↓
        {19, 9, 14, 24, 29, 27}
                    ⇈
                Left Right

        Now, a[pivot] = 24, a[left] = 24, and a[right] = 24. So, pivot, left and right are pointing the same element.
        It represents the termination of procedure.

        Element 24, which is the pivot element is placed at its exact position.

        Elements that are right side of element 24 are greater than it, and the elements that are left side of element
        24 are smaller than it.

        {19, 9, 14, 24, 29, 27}
         ↥-------↥      ↥---↥
         Left sub     Right sub
          array         array

        Now, in a similar manner, quick sort algorithm is separately applied to the left and right sub-arrays. After
        sorting gets done, the array will be:

        {9, 14, 19, 24, 27, 29}

        Best Case -> O(n*log n);
        Average Case -> O(n*log n);
        Worst Case -> O(n^2);

        Though the worst-case complexity of quicksort is more than other sorting algorithms such as Merge sort and
        Heap sort, still it is faster in practice. Worst case in quick sort rarely occurs because by changing the choice
        of pivot, it can be implemented in different ways. Worst case in quicksort can be avoided by choosing the right
        pivot element.

        Space Complexity -> O(n*log n);
        Stable -> No;

        */

        int[] numbers = { 13, 18, 27, 2, 19, 25 };
        System.out.println("\nBefore sorting array elements are - ");
        printArr(numbers);
        quick(numbers, 0, numbers.length - 1);
        System.out.println("\nAfter sorting array elements are - ");
        printArr(numbers);
        System.out.println();
    }

    /* function that consider last element as pivot, place the pivot at its exact position, and place
       smaller elements to left of pivot and greater elements to right of pivot.  */
   static int partition (int[] arr, int start, int end) {
        int pivot = arr[end]; // pivot element
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++; // increment index of smaller element
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int t = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = t;
        return (i + 1);
   }

    /* function to implement quick sort */
    static void quick(int[] arr, int start, int end) {/* a[] = array to be sorted, start = Starting index, end = Ending index */
        if (start < end) {
            int p = partition(arr, start, end);  //p is partitioning index
            quick(arr, start, p - 1);
            quick(arr, p + 1, end);
        }
    }

    /* function to print an array */
   static void printArr(int[] arr) {
        for (int i : arr)
            System.out.print(i+ " ");
    }
}
