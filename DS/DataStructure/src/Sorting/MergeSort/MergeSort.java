package Sorting.MergeSort;

public class MergeSort {
    public static void main(String[] args) {

        /*

        Merge sort is similar to the quick sort algorithm as it uses the divide and conquer approach to sort the elements.
        It is one of the most popular and efficient sorting algorithm. It divides the given list into two equal halves,
        calls itself for the two halves and then merges the two sorted halves. We have to define the merge() function to
        perform the merging.

        The sub-lists are divided again and again into halves until the list cannot be divided further. Then we combine
        the pair of one element lists into two-element lists, sorting them in the process. The sorted two-element pairs
        is merged into the four-element lists, and so on until we get the sorted list.


        Now, let's see the algorithm of merge sort.

        In the following algorithm, arr is the given array, beg is the starting element, and end is the last
        element of the array.

        The important part of the merge sort is the MERGE function. This function performs the merging of two sorted
        sub-arrays that are A[beg…mid] and A[mid+1…end], to build one sorted array A[beg…end]. So, the inputs of the
        MERGE function are A[], beg, mid, and end.


        Now, let's see the working of merge sort Algorithm.

        To understand the working of the merge sort algorithm, let's take an unsorted array. It will be easier to
        understand the merge sort via an example.

        Let the elements of array are:

        {12, 31, 25, 8, 32, 17, 40, 42}

        According to the merge sort, first divide the given array into two equal halves. Merge sort keeps dividing the
        list into equal parts until it cannot be further divided.

        As there are eight elements in the given array, so it is divided into two arrays of size 4.

        divide {12, 31, 25, 8} {32, 17, 40, 42}

        Now, again divide these two arrays into halves. As they are of size 4, so divide them into new arrays of size 2.

        divide {12, 31} {25, 8} {32, 17} {40, 42}

        Now, again divide these arrays to get the atomic value that cannot be further divided.

        divide {12} {31} {25} {8} {32} {17} {40} {42}

        Now, combine them in the same manner they were broken.

        In combining, first compare the element of each array and then combine them into another array in sorted order.

        So, first compare 12 and 31, both are in sorted positions. Then compare 25 and 8, and in the list of two values,
        put 8 first followed by 25. Then compare 32 and 17, sort them and put 17 first followed by 32. After that, compare
        40 and 42, and place them sequentially.

        merge {12, 31} {8, 25} {17, 32} {40, 42}

        In the next iteration of combining, now compare the arrays with two data values and merge them into an array of
        found values in sorted order.

        merge {8, 12, 25, 31} {17, 32, 40, 42}

        Now, there is a final merging of the arrays. After the final merging of above arrays, the array will look like:

        {8, 12, 17, 25, 31, 32, 40, 42}

        Now, the array is completely sorted.

        Best Case -> O(n*log n);
        Average Case -> O(n*log n);
        Worst Case -> O(n*log n);

        Space Complexity -> O(n);
        Stable -> Yes;

        */

        int[] arr = { 11, 30, 24, 7, 31, 16, 39, 41 };
        System.out.println("\nBefore sorting array elements are - ");
        printArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("\nAfter sorting array elements are - ");
        printArray(arr);
        System.out.println();

    }

    /* Function to merge the sub arrays of arr[] */
    static void merge(int[] arr, int beg, int mid, int end) {

        int n1 = mid - beg + 1, n2 = end - mid, i, j, k;

        /* temporary Arrays */
        int[] LeftArray = new int[n1];
        int[] RightArray = new int[n2];

        /* copy data to temp arrays */
        for (i = 0; i < n1; i++)
            LeftArray[i] = arr[beg + i];
        for (j = 0; j < n2; j++)
            RightArray[j] = arr[mid + 1 + j];

        i = 0; /* initial index of first sub-array */
        j = 0; /* initial index of second sub-array */
        k = beg;  /* initial index of merged sub-array */

        while (i < n1 && j < n2) {
            if(LeftArray[i] <= RightArray[j]) {
                arr[k] = LeftArray[i];
                i++;
            }
            else {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = RightArray[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int[] arr, int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergeSort(arr, beg, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, beg, mid, end);
        }
    }

    /* Function to print the array */
    static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
    }
}
