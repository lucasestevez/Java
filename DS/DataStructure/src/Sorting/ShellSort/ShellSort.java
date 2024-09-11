package Sorting.ShellSort;

public class ShellSort {
    public static void main(String[] args) {

        /*

        It is a sorting algorithm that is an extended version of insertion sort. Shell sort has improved the average
        time complexity of insertion sort. As similar to insertion sort, it is a comparison-based and in-place sorting
        algorithm. Shell sort is efficient for medium-sized data sets.

        In insertion sort, at a time, elements can be moved ahead by one position only. To move an element to a far-away
        position, many movements are required that increase the algorithm's execution time. But shell sort overcomes this
        drawback of insertion sort. It allows the movement and swapping of far-away elements as well.

        This algorithm first sorts the elements that are far away from each other, then it subsequently reduces the gap
        between them. This gap is called as interval. This interval can be calculated by using the Knuth's formula given
        below:

        hh = h * 3 + 1
        where, 'h' is the interval having initial value 1.

        Now, let's see the working of the shell sort Algorithm.

        To understand the working of the shell sort algorithm, let's take an unsorted array. It will be easier to
        understand the shell sort via an example.

        Let the elements of array are:

        {33, 31, 40, 8, 12, 17, 25, 42}

        We will use the original sequence of shell sort, i.e., N/2, N/4,....,1 as the intervals.

        In the first loop, n is equal to 8 (size of the array), so the elements are lying at the interval of 4 (n/2 = 4).
        Elements will be compared and swapped if they are not in order.

        Here, in the first loop, the element at the 0th position will be compared with the element at 4th position.
        If the 0th element is greater, it will be swapped with the element at 4th position. Otherwise, it remains
        the same. This process will continue for the remaining elements.

        At the interval of 4, the sublists are {33, 12}, {31, 17}, {40, 25}, {8, 42}.

        {33, 31, 40, 8, 12, 17, 25, 42}
         ↓   |   |   |  ↓   |   |   |
        [33] ↓   |   | [12] ↓   |   |
            [31] ↓   |     [17] ↓   |
                [40] ↓         [25] ↓
                    [8]            [42]

        Now, we have to compare the values in every sub-list. After comparing, we have to swap them if required in the
        original array. After comparing and swapping, the updated array will look as follows:

        {12, 17, 25, 8, 33, 31, 40, 42}

        In the second loop, elements are lying at the interval of 2 (n/4 = 2), where n = 8.

        Now, we are taking the interval of 2 to sort the rest of the array. With an interval of 2, two sublists will be
        generated - {12, 25, 33, 40}, and {17, 8, 31, 42}.

        {12, 17, 25, 8, 33, 31, 40, 42}
         ↓   |   ↓   |   ↓  |   ↓   |
        [12] ↓  [25] ↓  [33]↓  [40] ↓
            [17]    [8]    [31]    [42]

        Now, we again have to compare the values in every sub-list. After comparing, we have to swap them if required in
        the original array. After comparing and swapping, the updated array will look as follows:

        {12, 8, 25, 17, 33, 31, 40, 42}

        In the third loop, elements are lying at the interval of 1 (n/8 = 1), where n = 8. At last, we use the interval
        of value 1 to sort the rest of the array elements. In this step, shell sort uses insertion sort to sort the array
        elements.

        {12, 8, 25, 17, 33, 31, 40, 42}
        {12, 8, 25, 17, 33, 31, 40, 42}
        {8, 12, 25, 17, 33, 31, 40, 42}
        {8, 12, 25, 17, 33, 31, 40, 42}
        {8, 12, 17, 25, 33, 31, 40, 42}
        {8, 12, 17, 25, 33, 31, 40, 42}
        {8, 12, 17, 25, 33, 31, 40, 42}
        {8, 12, 17, 25, 31, 33, 40, 42}
        {8, 12, 17, 25, 31, 33, 40, 42}
        {8, 12, 17, 25, 31, 33, 40, 42}

        Now, the array is sorted in ascending order.

        Best Case -> O(n*log n);
        Average Case -> O(n*log (n)^2);
        Worst Case -> O(n^2);

        Space Complexity -> O(1);
        Stable -> No;

        */

        int[] numbers = { 30, 28, 37, 5, 9, 14, 22, 39 };
        System.out.print("Before sorting array elements are - \n");
        printArr(numbers);
        shell(numbers);
        System.out.print("\nAfter applying shell sort, the array elements are - \n");
        printArr(numbers);

    }

    static void shell(int[] arr) {
        /* Rearrange the array elements at n/2, n/4, ..., 1 intervals */
        for (int interval = arr.length/2; interval > 0; interval /= 2) {
            for (int i = interval; i < arr.length; i += 1) {
            /* store a[i] to the variable temp and make the ith position empty */
                int temp = arr[i];
                int j;
                for (j = i; j >= interval && arr[j - interval] > temp; j -= interval)
                    arr[j] = arr[j - interval];
            /* put temp (the original a[i]) in its correct position */
                arr[j] = temp;
            }
        }
    }

    static void printArr(int[] arr) {/* function to print the array elements */
        for (int i : arr)
            System.out.print(i + " ");
    }
}
