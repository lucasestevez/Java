package Sorting.RadixSort;

public class RadixSort {
    public static void main(String[] args) {

        /*

        The process of radix sort works similar to the sorting of students names, according to the alphabetical order.
        In this case, there are 26 radix formed due to the 26 alphabets in English. In the first pass, the names of
        students are grouped according to the ascending order of the first letter of their names. After that, in the
        second pass, their names are grouped according to the ascending order of the second letter of their name.
        And the process continues until we find the sorted list.

        Now, let's see the working of Radix sort Algorithm.

        The steps used in the sorting of radix sort are listed as follows -

         - First, we have to find the largest element (suppose max) from the given array. Suppose 'x' be the number of
           digits in max. The 'x' is calculated because we need to go through the significant places of all elements.

         - After that, go through one by one each significant place. Here, we have to use any stable sorting algorithm
           to sort the digits of each significant place.

        Now let's see the working of radix sort in detail by using an example. To understand it more clearly, let's
        take an unsorted array and try to sort it using radix sort. It will make the explanation clearer and easier.

        {181, 289, 390, 121, 145, 736, 514, 212}

        In the given array, the largest element is 736 that have 3 digits in it. So, the loop will run up to three times
        (i.e., to the hundreds place). That means three passes are required to sort the array.

        Now, first sort the elements on the basis of unit place digits (i.e., x = 0). Here, we are using the counting
        sort algorithm to sort the elements.


        Pass 1:

        In the first pass, the list is sorted on the basis of the digits at 0's place.

        {18[1]}                 {390} 0
        {28[9]}                 {181, 121} 1
        {39[0]}                 {212} 2
        {12[1]} --------------→ {   } 3
        {14[5]}                 {514} 4
        {73[6]}                 {145} 5
        {51[4]}                 {736} 6
        {21[2]}                 {   } 7
                                {   } 8
                                {289} 9

        After the first pass, the array elements are:

        {390, 181, 121, 212, 514, 145, 736, 289}


        Pass 2:

        In this pass, the list is sorted on the basis of the next significant digits (i.e., digits at 10th place).

        {3[9]0}                 {   } 0
        {1[8]1}                 {212, 514} 1
        {1[2]1}                 {121} 2
        {2[1]2} --------------→ {736} 3
        {5[1]4}                 {145} 4
        {1[4]5}                 {   } 5
        {7[3]6}                 {   } 6
        {2[8]9}                 {   } 7
                                {181, 289} 8
                                {390} 9

        After the second pass, the array elements are:

        {212, 514, 121, 736, 145, 181, 289, 390}


        Pass 3:

        In this pass, the list is sorted on the basis of the next significant digits (i.e., digits at 100th place).

        {[2]12}                 {   } 0
        {[5]14}                 {121, 145, 181} 1
        {[1]21}                 {212, 289} 2
        {[7]36} --------------→ {390} 3
        {[1]45}                 {   } 4
        {[1]81}                 {514} 5
        {[2]89}                 {   } 6
        {[3]90}                 {736} 7
                                {   } 8
                                {   } 9

        After the third pass, the array elements are:

        {121, 145, 181, 212, 289, 390, 514, 736}

        Now, the array is sorted in ascending order.

        Best Case -> Ω(n+k);
        Average Case -> θ(nk);
        Worst Case -> O(nk);

        Radix sort is a non-comparative sorting algorithm that is better than the comparative sorting algorithms.
        It has linear time complexity that is better than the comparative algorithms with complexity O(n log n).

        Space Complexity -> O(n + k);
        Stable -> Yes;

        */

        int[] numbers = {151, 259, 360, 91, 115, 706, 34, 858, 2};
        System.out.print("Before sorting array elements are - \n");
        printArray(numbers);
        radixSort(numbers);
        System.out.print("\n\nAfter applying Radix sort, the array elements are - \n");
        printArray(numbers);

    }

    static int getMax(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max)
                max = arr[i];
        }
        return max; //maximum element from the array
    }

    static void countingSort(int[] arr, int n, int place) { // function to implement counting sort
        int[] outPut = new int[n+1];
        int[] count = new int[10];

        // Calculate count of elements
        for (int i = 0; i < n; i++)
            count[(arr[i] / place) % 10]++;

        // Calculate cumulative frequency
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = n - 1; i >= 0; i--) {
            outPut[count[(arr[i] / place) % 10] - 1] = arr[i];
            count[(arr[i] / place) % 10]--;
        }

        if (n >= 0) System.arraycopy(outPut, 0, arr, 0, n);
    }

    // function to implement radix sort
    static void radixSort(int[] arr) {
        // get maximum element from array
        int max = getMax(arr);

        // Apply counting sort to sort elements based on place value
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(arr, arr.length, place);
    }

    // function to print array elements
    static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
    }
}
