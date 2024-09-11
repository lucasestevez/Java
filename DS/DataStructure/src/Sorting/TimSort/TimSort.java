package Sorting.TimSort;

public class TimSort {
    public static void main(String[] args) {

        /*

        Tim sort is an adaptive sorting algorithm that needs O(n log n) comparisons to sort an array of n elements.
        It was designed and implemented by Tim Peters in 2002 in a python programming language. It has been python's
        standard sorting algorithm since version 2.3. It is the fastest sorting algorithm.

        The basic approach used in the Tim sort algorithm is - first sort small chunks by using the insertion sort and
        then merge all the big chunks using the merge function of the merge sort.

        Now, let's see the algorithm of Tim sort.

        Step 1 - Divide the array into the number of blocks known as run.
        Step 2 - Consider the size of run, either 32 or 64.
        Step 3 - Sort the individual elements of every run one by one using insertion sort.
        Step 4 - Merge the sorted runs one by one using the merge function of merge sort.
        Step 5 - Double the size of merged sub-arrays after every iteration.

        Now, let's see the working of the Tim sort Algorithm.

        In Tim sort, first the array is divided into small chunks that are known as RUN. After dividing, each individual
        RUN is taken, and sorted using the insertion sort technique. After that, all sorted RUNs are merged using the
        merge() function of the merge sort algorithm.

        In Tim sort, the advantage of using the insertion sort is that insertion sort works efficiently for the array
        with small size.

        Let's see the example of Tim sort algorithm. To understand the working of Tim sort algorithm, let's take an
        unsorted array. It will be easier to understand the Tim sort via an example.

        Suppose the array elements are:

        {40, 10, 20, 42, 27, 25, 1, 19}

        For the simple illustration, let's consider the size of RUN is 4.

        Now, divide the given array into two sub-arrays that are:

        {40, 10, 20, 42} {27, 25, 1, 19}


        The first sub-array is:

        {40, 10, 20, 42}

        Sorted subarray     Unsorted subarray       Array
            (40)              (10, 20, 42)     (40, 10, 20, 42)


        First Iteration

        a[1] = 10;

        Sorted subarray     Unsorted subarray       Array
          (10, 40)              (20, 42)       (10, 40, 20, 42)


        Second iteration

        a[2] = 20;

        Sorted subarray     Unsorted subarray       Array
         (10, 20, 40)             (42)         (10, 20, 40, 42)


        Third iteration

        a[3] = 42;

        Sorted subarray     Unsorted subarray       Final Array
        (10, 20, 40, 42)           ()            (10, 20, 40, 42)


        The second sub-array is:

        {27, 25, 1, 19}

        Sorted subarray     Unsorted subarray       Array
            (27)              (25, 1, 19)      (27, 25, 1, 19)


        First Iteration

        a[1] = 25;

        Sorted subarray    Unsorted subarray       Array
           (25, 27)             (1, 19)       (25, 27, 1, 19)


        Second Iteration

        a[2] = 1;

        Sorted subarray    Unsorted subarray      Array
          (1, 25, 27)            (19)        (1, 25, 27, 19)


        Third Iteration

        a[3] = 19;

        Sorted subarray  Unsorted subarray     Array
        (1, 19, 25, 27)          ()        (1, 19, 25, 29)


        Now, merge both sorted sub arrays to get the final array as:

        {10, 20, 40, 42} {1, 19, 25, 27}

        {1, 10, 19, 20, 25, 29, 40, 42}

        Now, the array is completely sorted.

        Best Case -> O(n);
        Average Case -> O(n log n);
        Worst Case -> O(n log n);

        Space Complexity -> O(n);
        Stable -> Yes;

        */

        int[] numbers = { 38, 10, 29, 25, 23, 6, 2, 30, 15 };
        System.out.print("\nBefore sorting array elements are - \n");
        printArr(numbers);
        timSort(numbers);
        System.out.print("\nAfter sorting array elements are - \n");
        printArr(numbers);
        System.out.println();

    }

    static int RUN = 32;
    static int min(int a, int b) {
        return Math.min(a, b);
    }

    /* This function sorts array from starting index to ending index which is of size at most RUN */
    static void insertionSort(int[] arr, int beg, int end) {/* function to sort an array with
        insertion sort */
        for (int i = beg + 1; i <= end; i++) {
            int temp = arr[i];
            int j = i - 1;

            while(j >= beg && temp <= arr[j]) {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = temp;
        }
    }

    /* Function to merge the sorted runs */
    static void merge(int[] arr, int beg, int mid, int end) {
        int i, j, k;
        int n1 = mid - beg + 1;
        int n2 = end - mid;
        //temporary arrays
        int[] LeftArray = new int [n1];
        int[] RightArray = new int [n2];
        /* copy data to temp arrays */
        for (i = 0; i < n1; i++)
            LeftArray[i] = arr[beg + i];
        for  (j = 0; j < n2; j++)
            RightArray[j] = arr[mid + 1 + j];
        i = 0;
        j = 0;
        k = beg;
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

    /* function to implement tim sort */
    static void timSort(int[] arr) {
        /* Sort individual sub arrays of size RUN */
        for (int i = 0; i < arr.length; i+=RUN)
            insertionSort(arr, i, min((i+RUN-1), (arr.length - 1)));
        // Start merging from size RUN (or 32).
        for (int size = RUN; size < arr.length; size = 2*size) {
            for (int beg = 0; beg < arr.length; beg += 2*size) {
                /* find ending point of left subarray. The starting point of right sub array is mid + 1 */
                int mid = beg + size - 1;
                int end = min((beg + 2*size - 1),(arr.length-1));
                /* Merge subarray a[beg...mid] and a[mid + 1...end] */
                if(mid < end)
                    merge(arr, beg, mid, end);
            }
        }
    }

    /* function to print the array elements */
    static void printArr(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
    }
}
