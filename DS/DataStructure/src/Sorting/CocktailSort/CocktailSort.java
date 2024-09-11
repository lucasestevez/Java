package Sorting.CocktailSort;

public class CocktailSort {
    public static void main(String[] args) {

        /*

        Cocktail sort is also called as bidirectional bubble sort. In bubble sort, elements are traversed from left to right,
        i.e., in one direction. In first iteration, bubble sort first moves the largest element to its correct position,
        then the second-largest element in its exact position, and so on. But cocktail sort traverses in both directions
        alternatively.

        As similar to the bubble sort, the worst and average case complexities of cocktail sort is O(n^2). Cocktail sort
        is faster than bubble sort.

        There are two stages of cocktail sort in one iteration that are listed as follows:

         - In first stage, similar to the bubble sort, loop through the array from left to right. The adjacent elements
           are compared, and if the left element is greater than the right one, we swap those elements. The largest element
           of the list is placed at the end of the array in the forward pass.

        - In second stage, loop through the array from the rightmost unsorted element to the left. The adjacent
          elements are compared, and if the right element is smaller than the left element then, we swap those elements.
          The smallest element of the list is placed at the beginning of the array in the backward pass.

        This process continues until the array elements are not sorted.

        Now, let's see the working of the cocktail sort Algorithm.

        To understand the working of the cocktail sort algorithm, let's take an unsorted array. We are taking a short
        and accurate array, as we know the complexity of the cocktail sort is O(n^2).

        Let the elements of array are:

        Array = {4, 0, 3, 1, 7, 1, 2}


        Iteration 1:

        First Forward pass:

        In first iteration, the forward pass is similar to the bubble sort. The comparisons of forward pass in first
        iteration are given as follows:

        Sorting will start from the initial two elements. Let compare them to check which is greater.

        {4, 0, 3, 1, 7, 1, 2}   (0 < 4), swap

        After swapping new array will look like:

        {0, 4, 3, 1, 7, 1, 2}

        Now compare 4 and 3.

        {0, 4, 3, 1, 7, 1, 2}   (3 < 4), swap

        After swapping new array will look like:

        {0, 3, 1, 4, 7, 1, 2}

        Now, compare 4 and 1.

        {0, 3, 4, 1, 7, 1, 2}   (1 > 4), swap

        After swapping new array will look like:

        {0, 3, 1, 4, 7, 1, 2}

        Now, compare 4 and 7.

        {0, 3, 1, 4, 7, 1, 2}   (7 < 4), no swap

        Now, the comparison will be between 7 and 1.

        {0, 3, 1, 4, 7, 1, 2}   (1 < 7), swap

        After swapping new array will look like:

        {0, 3, 1, 4, 1, 7, 2}

        Now, compare 7 and 2.

        {0, 3, 1, 4, 1, 7, 2}   (2 < 7), swap

        Now, we reach at the end of the array. After swapping and first forward pass, the array elements will look like:

        {0, 3, 1, 4, 1, 2, 7}

        After the first forward pass, the largest element of the array is stored at the last position of the array.

        First Backward pass:

        Now, the first backward pass is started. It will be started from the last index of the array except for the
        index where the largest element is stored.

        So, from the backward direction, first array elements 2 and 1 will be compared.

        {0, 3, 1, 4, 1, 2, 7}   (1 < 2), no swap

        Now compare, 1 and 4.

        {0, 3, 1, 4, 1, 2, 7}   (1 < 4), swap

        After swapping, the array will be:

        {0, 3, 1, 1, 4, 2, 7}

        Now compare, 3 and 1.

        {0, 3, 1, 1, 4, 2, 7}   (3 > 1), swap

        After swapping, the array will be:

        {0, 1, 3, 1, 4, 2, 7}

        Now compare, 0 and 1.

        {0, 1, 3, 1, 4, 2, 7}   (0 < 1). no swap

        So, after the first backward pass, smallest element from the array is stored at the first index of array.
        So, after first iteration, the array elements will be:

        {0, 1, 3, 1, 4, 2, 7}


        Iteration 2:

        Second Forward pass:

        Now, the second forward pass is started. It will be started from the first index of the array except for the
        index where the smallest element is stored.

        So, from the forward direction, first array elements 1 and 3 will be compared.

        {0, 1, 3, 1, 4, 2, 7}   (3 > 1), no swap

        {0, 1, 3, 1, 4, 2, 7}   (1 < 3), swap

        {0, 1, 1, 3, 4, 2, 7}   (4 > 3), no swap

        {0, 1, 1, 3, 4, 2, 7}   (2 < 4), swap

        Now, we reach at the end of the array. After the second forward pass, the second-largest array element will be
        stored at its exact position. After swapping and second forward pass, the array elements will look like:

        {0, 1, 1, 3, 4, 2, 7}

        Second Backward pass:

        Now, the second backward pass is started.

        So, from backward direction, array elements 3 and 2 will be compared.

        {0, 1, 1, 3, 4, 2, 7}   (3 > 2), swap

        After swapping, the array will be:

        {0, 1, 1, 2, 3, 4, 7}

        Now, the array is completely sorted, but the algorithm has to complete the entire pass without any swap to know
        that the array is sorted.

        {0, 1, 1, 2, 3, 4, 7}   (2 > 1), no swap

        {0, 1, 1, 2, 3, 4, 7}   no swap

        So, after sorting the array elements will be:

        {0, 1, 1, 2, 3, 4, 7}

        Now, the array is completely sorted.

        Best Case -> O(n);
        Average Case -> O(n^2);
        Worst Case -> O(n^2);

        Space Complexity -> O(1);
        Stable -> Yes.

        */

        int[] nums = {37, 3, 27, 2, 67, 0, 17};
        System.out.print("Before sorting array elements are - \n");
        print(nums);
        cocktail(nums);
        System.out.print("\nAfter sorting array elements are - \n");
        print(nums);
    }

    /* function to implement Cocktail sort */
    static void cocktail(int[] nums) {
        int swap = 1, beg = 0, end = nums.length - 1;

        while (swap == 1) {
            swap = 0;

        /* Loop similar to bubble sort to compare and swap array elements starting from left to right */
            for (int i = beg; i < end; ++i) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swap = 1;
                }
            }

            if (swap == 0)
                break;
            swap = 0;

        /* decrease the 'end' point by one position. It is because the item at the last position is at its
           correct position */
            --end;

        /* This loop starts from right to left to perform the same comparison as in the previous loop */
            for (int i = end - 1; i >= beg; --i) {
                if (nums[i] > nums[i + 1]) {
                   int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swap = 1;
                }
            }

        /* increase the beginning point by one position. It is because the item at the first position is at its
        correct position */
            ++beg;
        }
    }

    static void print(int[] nums) {//function to print array elements
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
