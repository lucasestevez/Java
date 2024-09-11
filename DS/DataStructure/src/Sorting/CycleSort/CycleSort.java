package Sorting.CycleSort;

public class CycleSort {
    public static void main(String[] args) {

        /*

        It is an in-place and unstable sorting algorithm. Cycle sort forces an array to be factored into a number of
        cycles where every element can rotate in order to produce a sorted array. The time complexity of cycle sort is
        O(n2), even in the best case.

        Now, let's see the algorithm of cycle sort.

        Suppose there is an array arr with n distinct elements. Given an element A, we can find its index by counting
        the number of elements smaller than A.

        1. If the element is at its correct position, simply leave it as it is.

        2. Else, we have to find the correct position of A by counting the number of elements smaller than it. Another
           element B is replaced to be moved to its correct position. This process continues until we get an element at
           the original position of A.

        The above-illustrated process constitutes a cycle. Repeat this cycle for every element of the list until the
        list is sorted.

        Now, let's see the working of Cycle sort Algorithm. To understand the working of cycle sort algorithm, let's
        take an unsorted array.

        Let the elements of array are - {30, 20, 10, 40, 60, 50}

                                Now first count the number of elements
                                less than 30, here there are 2 elements
                                less than 30, so, move 30 to the 3rd place
         30                     of the list.                            30 -----↧
        {30, 20, 10, 40, 60. 50} ------------------------------------→ {30, 20, 10, 40, 60, 50}
                                                                                 | Count the number of elements
                                 Now the original position of 30 is              | that are less than 10. Here, there
                                 acquired, so 1st cycle is completed.            | are 0, so, move 10 to the first
                                                                    ↧------ 10   ↓ position.
        {10, 20, 30, 40, 60, 50} ←---------------------------------{10, 20, 30, 40, 60, 50}
             |
             |  The cycle for the first 4 elements is same so,
             |  we are starting with element at 5th position/(i.e.,60).
             |
             |  For next cycle, count the number of elements less
             |  than 60, here, there are five elements less than 60.
             |  So, move it to the 6th position of the array (or at index 5)
             |
             |                                               Now, count the number of elements less than
             |                                               50. Here, there are 4 elements less than 50, so we
             |                                               have to place 50 at 5th position of the array for at
             |                                       60 -↴   4th index.
             |--------------------→ {10, 20, 30, 40, 60, 50} -------------------------------------------↴
                                                                                                        |
                                                                                                        |
                           Now the originals position of 50 is                                          |
                           acquired, so this cycle is completed.                   ↶ 50                 |
            {10, 20, 30, 40, 50, 60} ←--------------------------{10, 20, 30, 40, 60, 50} ←--------------↵

            Best Case -> O(n^2)
            Average Case -> O(n^2)
            Worst Case -> O(n^2)

            The time complexity of cycle sort in all three cases in O(n2). Even in the best case, it takes O(n2) time to
            sort the array elements. In Cycle sort, there is always the traversing of the entire subarray from the current
            position in order to count the number of elements less than the current element.

            So, in cycle sort, it doesn't matter whether the given array is already sorted or not. It has no consequence
            on the running time of the algorithm. So, the cycle sort must run in the quadratic time.

            Space Complexity -> O(1)
            Stable -> No

        */

        int[] numbers = {87, 42, 27, 17, 7, 37, 57, 47, 2, 1};
        System.out.print("Before sorting array elements are - \n");
        print(numbers);
        cycleSort(numbers);
        System.out.print("\nAfter applying cycle sort, array elements are - \n");
        print(numbers);
    }


    static void cycleSort(int[] arr) {
        /*Loop to traverse the array elements and place them on the correct position*/
        for (int start = 0; start <= arr.length - 2; start++) {
             int element = arr[start];

            /*position to place the element*/
            int pos = start;

            for (int i = start + 1; i < arr.length; i++)
                if (arr[i] < element)
                    pos++;

            if (pos == start)  /*if the element is at exact position*/
                continue;

            while (element == arr[pos])
                pos += 1;

            if (pos != start) { /*put element at its exact position*/
                //swap(element, a[pos]);
                int temp = element;
                element = arr[pos];
                arr[pos] = temp;
            }
            /*Rotate rest of the elements*/
            while (pos != start) {
                pos = start;
                /*find position to put the element*/
                for (int i = start + 1; i < arr.length; i++)
                    if (arr[i] < element)
                        pos += 1;

                /*Ignore duplicate elements*/
                while (element == arr[pos])
                    pos += 1;

                /*put element to its correct position*/
                if (element != arr[pos]) {
                    int temp = element;
                    element = arr[pos];
                    arr[pos] = temp;
                }
            }
        }
    }

    static void print(int[] arr) { /*function to print array elements*/
        for (int j : arr)
            System.out.print(j + " ");
    }

}
