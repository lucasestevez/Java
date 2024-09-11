package Sorting.BubbleSort;

public class BubbleSort {
    public static void main(String[] args) {

        /*

        Bubble sort works on the repeatedly swapping of adjacent elements until they are not in the intended order.
        It's called bubble sort 'cause the movement of array elements is just like the movement of air bubbles
        in the water. Bubbles in water rise up to the surface; similarly, the array elements in bubble sort move to the
        end in each iteration.

        Although it is simple to use, it is primarily used as an educational tool because the performance of bubble sort
        is poor in the real world. It's not suitable for large data sets. The average and worst-case complexity of
        Bubble sort is O(n^2), where n is a number of items.

        Bubble sort is majorly used where:
        - Complexity does not matter;
        - Simple and shortcode is preferred;


        To understand the working of bubble sort algorithm, let's take an unsorted array. We are taking a short and accurate
        array, as we know the complexity of bubble sort is O(n^2).

        ---- First Pass ----

        Let the elements of array are:

        {13, 32, 26, 35, 10}

        Sorting thing will start from the initial two elements. Let compare them to check which is greater.

        {13, 32, 26, 35, 10}

        Here, 32 is greater than 13 (32 > 13), so it is already sorted. Now, compare 32 with 26.

        {13, 32, 26, 35, 10}

        Here, 26 is smaller than 36. So, swapping is required. After swapping new array will look like:

        {13, 26, 32, 35, 10}

        Now, compare 32 and 35.

        {13, 26, 32, 35, 10}

        Here, 35 is greater than 32. So, there is no swapping required as they are already sorted. Now, the comparison
        will be in between 35 and 10.

        {13, 26, 32, 35, 10}

        Here, 10 is smaller than 35 that are not sorted. So, swapping is required. Now, we reach at the end of the array.
        After first pass, the array will be:

        {13, 26, 32, 10,35}

        Here, 10 is smaller than 32. So swapping is required. After swapping, the array will be:

        {13, 26, 10, 32, 35}

        Here, 10 is smaller than 26. So, swapping is required. After swapping, the array will be:

        {13, 10, 26, 32, 35}

        Similarly, after the fourth iteration, the array will be:

        {10, 13, 26, 32, 35}

        Hence, there is no swapping required, so the array is completely sorted.


        Best case -> O(n);
        Average Case -> O(n^2);
        Worst Case -> O(n^2);

        Space Complexity -> O(1);
        Stable -> Yes;
    */
        int[] num = {50, 10, 31, 11, 26, 25, 300, 7, 90, 18, 98, 87, 72};
        System.out.println("Before sorting array elements are - ");
        print(num);
        bubbleSort(num);
        System.out.println();
        System.out.println("After sorting array elements are - ");
        print(num);

    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void print(int[] num) {
        for (int i : num) {
            System.out.println(i + "");
        }
    }
}
