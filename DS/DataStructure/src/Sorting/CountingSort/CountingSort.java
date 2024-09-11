package Sorting.CountingSort;

public class CountingSort {
    public static void main(String[] args) {

        /*

        This sorting technique doesn't perform sorting by comparing elements. It performs sorting by counting objects
        having distinct key values like hashing. After that, it performs some arithmetic operations to calculate each
        object's index position in the output sequence. Counting sort is not used as a general-purpose sorting algorithm.

        Counting sort is effective when range is not greater than number of objects to be sorted. It can be used to
        sort the negative input values.

        Now, let's see the algorithm of counting sort.

        Now, let's see the working of the counting sort Algorithm.

        To understand the working of the counting sort algorithm, let's take an unsorted array. It will be easier to
        understand the counting sort via an example.

        Let the elements of array are:

        {2, 9, 7, 4, 1, 8, 4}

        1. Find the maximum element from the given array. Let max be the maximum element.

        MAX
        {9}     {2, 7, 4, 1, 8, 4}

        2. Now, initialize array of length max + 1 having all 0 elements. This array will be used to store the count
        of the elements in the given array.

         0  1  2  3  4  5  6  7  8  9
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                  Count array

        3. Now, we have to store the count of each array element at their corresponding index in the count array.

        The count of an element will be stored as - Suppose array element '4' is appeared two times, so the count of
        element 4 is 2. Hence, 2 is stored at the 4th position of the count array. If any element is not present in the
        array, place 0, i.e. suppose element '3' is not present in the array, so, 0 will be stored at 3rd position.

        Given array {2, 9, 7, 4, 1, 8, 4}

                     0  1  2  3  4  5  6  7  8  9
        Count array {0, 1, 1, 0, 2, 0, 0, 1, 1, 1}
                     Count of each stored element

        Now, store the cumulative sum of count array elements. It will help to place the elements at the correct index
        of the sorted array.

         0  1  2  3  4  5  6  7  8  9
        {0, 1, 2, 0, 2, 0, 0, 1, 1, 1}
            1+1=2

         0  1  2  3  4  5  6  7  8  9
        {0, 1, 2, 2, 2, 0, 0, 1, 1, 1}
               2+0=2

        Similarly, the cumulative count of the count array is:

         0  1  2  3  4  5  6  7  8  9
        {0, 1, 2, 2, 4, 4, 4, 5, 6, 7}
               Cumulative count

        4. Now, find the index of each element of the original array


        For element 9

        Original array -> {2, 9, 7, 4, 1, 8, 4}

                        0  1  2  3  4  5  6  7  8  9
        Count array -> {0, 1, 1, 2, 4, 4, 4, 5, 6, 7}
                                                  7-1=6

        Output (sorted array) -> 0  1  2  3  4  5  6
                                { , 2,  ,  ,  ,  , 9}

        After placing element at its place, decrease its count by one. Before placing element 2, its count was 2, but after
        placing it at its correct position, the new count for element 2 is 1.


        For element 2

        Original array -> {2, 9, 7, 4, 1, 8, 4}

                        0  1  2  3  4  5  6  7  8  9
        Count array -> {0, 1, 2, 2, 4, 4, 4, 5, 6, 7}
                             2-1=1

        Output (sorted array) -> 0  1  2  3  4  5  6
                                { , 2,  ,  ,  ,  ,  }

        Similarly, after sorting, the array elements are:

        Output (sorted array) -> 0  1  2  3  4  5  6
                                {1, 2, 4, 4, 7, 8, 9}

        Now, the array is completely sorted.

        Best Case -> O(n + k);
        Average Case -> O(n + k);
        Worst Case -> O(n + k);

        In all above cases, the time complexity of counting sort is same. This is because the algorithm goes through
        n+k times, regardless of how the elements are placed in the array.

        Counting sort is better than the comparison-based sorting techniques because there is no comparison between elements
        in counting sort. But, when the integers are very large the counting sort is bad because arrays of that size have to
        be created.

        Space Complexity -> O(max);
        Stable -> Yes.

        */

        int[] numbers = { 11, 30, 24, 7, 31, 16, 39, 41 };
        System.out.println("\nBefore sorting array elements are - ");
        printArray(numbers);
        countSort(numbers);
        System.out.println("\nAfter sorting array elements are - ");
        printArray(numbers);
        System.out.println();
    }

    static int getMax(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max)
                max = arr[i];
        }
        return max; //maximum element from the array
    }

    static void countSort(int[] arr) {// function to perform counting sort
        int[] output = new int [arr.length + 1];
        int max = getMax(arr);
        //int max = 42;
        int[] count = new int [max+1]; //create count array with size [max+1]

        for (int i = 0; i <= max; ++i) {
            count[i] = 0; // Initialize count array with all zeros
        }

        for (int j : arr) {// Store the count of each element
            count[j]++;
        }

        for(int i = 1; i<=max; i++)
            count[i] += count[i-1]; //find cumulative frequency
          /* This loop will find the index of each element of the original array in count array, and
           place the elements in output array*/
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--; // decrease count for same numbers
        }
        //store the sorted elements into main array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
    }

}
