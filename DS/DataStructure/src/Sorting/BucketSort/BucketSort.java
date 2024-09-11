package Sorting.BucketSort;

public class BucketSort {
    public static void main(String[] args) {

        /*

        Bucket sort is a sorting algorithm that separate the elements into multiple groups said to be buckets. Elements in
        bucket sort are first uniformly divided into groups called buckets, and then they are sorted by any other sorting
        algorithm. After that, elements are gathered in a sorted manner.

        The basic procedure of performing the bucket sort  is given as follows:
        - First, partition the range into a fixed number of buckets;
        - Then, toss every element into its appropriate bucket;
        - After that, sort each bucket individually by applying a sorting algorithm;
        - And at last, concatenate all the sorted buckets.

        The advantages of bucket sort are:
        - Bucket sort reduces the num of comparisons;
        - It is asymptotically fast because of the uniform distribution of elements.

        The limitations of bucket sort are:
        - It may or may not be a stable sorting algorithm;
        - It's not useful if we have a large array because it increases the cost;
        - It's not an in-place sorting algorithm, because some extra space is required to sort the buckets.

        Bucket sort is commonly used:
        - With floating-point values;
        - When inputs is distributed uniformly over a range.

        We can understand the Bucket sort algorithm via scatter-gather approach. Here, the given elements are first
        scattered into buckets. After scattering, elements in each bucket are sorted using a stable sorting algorithm.
        At last, the sorted elements will be gathered in order.

        Let's take an unsorted array to understand the process of bucket sort. It will be easier to understand the
        bucket sort via an example.

        Let the elements of array are:

        {10, 8, 20, 7, 16, 18, 12, 1, 23, 11}

        Now, create buckets with a range from 0 to 25. The buckets range are 0-5, 5-10, 10-15, 15-20, 20-25.
        Elements are inserted in the buckets according to the bucket range. Suppose the value of an item is 16,
        so it will be inserted in the bucket with the range 15-20. Similarly, every item of the array will insert
        accordingly.

        This phase is known to be the scattering of array elements.

        { 1 } { 8, 7 } { 10, 12, 11 } { 20, 16, 18 } { 23 }
         0-5    5-10       10-15          15-20      20-25

        Now, sort each bucket individually. The elements of each bucket can be sorted by using any of the
        stable sorting algorithm.

        { 1 }  { 7, 8 } { 10, 11, 12 } { 16, 18, 20 } { 23 }
         0-5     5-10        10-15         15-20      20-25

        At last, gather the sorted elements from each bucket in order.

        {1, 7, 8, 10, 11, 12, 16, 18, 20, 23}

        Now, the array is completely sorted.

        Best Case -> O(n + k)
        Average Case -> O(n + k)
        Worst Case -> O(n^2)

        Space Complexity -> O(n*k)
        Stable -> Yes

        */

        int[] nums = {12, 40, 5, 90, 30, 9, 23, 65, 82, 100, 32, 46};
        System.out.print("Before sorting array elements are - \n");
        printArr(nums);
        bucket(nums);
        System.out.print("\nAfter sorting array elements are - \n");
        printArr(nums);
    }

    static int getMax(int[] arr) {// function to get maximum element from the given
        int max = arr[0];

        for (int i : arr)
            if (i > max)
                max = i;
        return max;
    }

    static void bucket(int[] arr) {// function to implement bucket sort
        int max = getMax(arr); //max is the maximum element of array
        int[] bucket = new int[max+1];

        for (int i = 0; i <= max; i++){
            bucket[i] = 0;
        }

        for (int k : arr) {
            bucket[k]++;

        }

        for (int i = 0, j = 0; i <= max; i++) {
            while (bucket[i] > 0) {
                arr[j++] = i;
                bucket[i]--;
            }
        }
    }

    static void printArr(int[] arr) {/* function to print the array */
        for (int j : arr)
            System.out.print(j + " ");
    }
}
