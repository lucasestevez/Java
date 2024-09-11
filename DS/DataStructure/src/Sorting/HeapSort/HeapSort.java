package Sorting.HeapSort;

public class HeapSort {
    public static void main(String[] args) {

        /*

        Heap sort basically recursively performs two main operations:

         - Build a heap H, using the elements of array.
         - Repeatedly delete the root element of the heap formed in 1st phase.

        Before knowing more about the heap sort, let's first see a brief description of Heap.

        What is a heap?

        A heap is a complete binary tree, and the binary tree is a tree in which the node can have the utmost two
        children. A complete binary tree is a binary tree in which all the levels except the last level, i.e., leaf node,
        should be completely filled, and all the nodes should be left-justified.

        What is heap sort?

        Heapsort is a popular and efficient sorting algorithm. The concept of heap sort is to eliminate the elements one
        by one from the heap part of the list, and then insert them into the sorted part of the list.

        Heapsort is the in-place sorting algorithm.

        Now, let's see the algorithm of heap sort.

        In heap sort, basically, there are two phases involved in the sorting of elements. By using the heap sort algorithm,
        they are as follows -

         - The first step includes the creation of a heap by adjusting the elements of the array.
         - After the creation of heap, now remove the root element of the heap repeatedly by shifting it to the end of
           the array, and then store the heap structure with the remaining elements.

        Now let's see the working of heap sort in detail by using an example. To understand it more clearly, let's take
        an unsorted array and try to sort it using heap sort. It will make the explanation clearer and easier.

        {81, 89, 9, 11, 14, 76, 54, 22}

        First, we have to construct a heap from the given array and convert it into max heap.

                      [81]                                      [89]
                     ↙    ↘              Heapify               ↙    ↘
                [89]        [9] --------------------------→ [81]     [76]
               ↙    ↘      ↙    ↘                          ↙  ↘      ↙   ↘
            [11]    [14] [76]   [54]                    [22]  [14] [9]   [54]
            ↙                                           ↙
          [22]                                       [11]
                     Heap                                     Max Heap

        After converting the given heap into max heap, the array elements are:

        {89, 81, 76, 22, 14, 9, 54, 11}

        Next, we have to delete the root element (89) from the max heap. To delete this node, we have to swap it with
        the last node, i.e. (11). After deleting the root element, we again have to heapify it to convert it into max heap.

                      [11]                                      [81]
                     ↙    ↘               Heapify              ↙    ↘
                [81]        [76] -------------------------→ [22]     [76]
               ↙    ↘      ↙    ↘                           ↙  ↘     ↙  ↘
            [22]    [14] [9]   [54]                       [11] [14] [9] [54]

             Heap after deleting 89                            Max Heap

        After swapping the array element 89 with 11, and converting the heap into max-heap, the elements of array are:

        {81, 22, 76, 11, 14, 9, 54, 89}

        In the next step, again, we have to delete the root element (81) from the max heap. To delete this node,
        we have to swap it with the last node, i.e. (54). After deleting the root element, we again have to heapify
        it to convert it into max heap.

                      [54]                                      [76]
                     ↙    ↘               Heapify              ↙    ↘
                [22]        [76] -------------------------→ [22]     [54]
               ↙    ↘      ↙                                ↙  ↘     ↙
            [11]    [14] [9]                             [11] [14] [9]

            Heap after deleting 81                            Max Heap

        After swapping the array element 81 with 54 and converting the heap into max-heap, the elements of array are:

        {76, 22, 54, 11, 14, 9, 81, 89}

        In the next step, we have to delete the root element (76) from the max heap again. To delete this node,
        we have to swap it with the last node, i.e. (9). After deleting the root element, we again have to heapify
        it to convert it into max heap.

                      [9]                                      [54]
                     ↙    ↘               Heapify              ↙    ↘
                [22]        [54] -------------------------→ [22]     [9]
               ↙    ↘                                       ↙  ↘
            [11]    [14]                                 [11] [14]

            Heap after deleting 76                            Max Heap

        After swapping the array element 76 with 9 and converting the heap into max-heap, the elements of array are:

        {54, 22, 9, 11, 14, 76, 81, 89}

        In the next step, again we have to delete the root element (54) from the max heap. To delete this node, we have
        to swap it with the last node, i.e. (14). After deleting the root element, we again have to heapify it to
        convert it into max heap.

                      [14]                                      [22]
                     ↙    ↘               Heapify              ↙    ↘
                [22]        [9] -------------------------→ [14]     [9]
               ↙                                           ↙
            [11]                                        [11]

             Heap after deleting 54                            Max Heap

        After swapping the array element 54 with 14 and converting the heap into max-heap, the elements of array are:

        {22, 14, 9, 11, 54, 76, 81, 89}

        In the next step, again we have to delete the root element (22) from the max heap. To delete this node, we have
        to swap it with the last node, i.e. (11). After deleting the root element, we again have to heapify it to convert
        it into max heap.

                      [11]                                      [14]
                     ↙    ↘               Heapify              ↙    ↘
                [14]        [9] -------------------------→ [11]     [9]

             Heap after deleting 22                            Max Heap

        After swapping the array element 22 with 11 and converting the heap into max-heap, the elements of array are:

        {14, 11, 9, 22, 54, 76, 81, 89}

        In the next step, again we have to delete the root element (14) from the max heap. To delete this node, we have
        to swap it with the last node, i.e. (9). After deleting the root element, we again have to heapify it to convert
        it into max heap.

                      [9]                                      [11]
                     ↙                   Heapify              ↙
                [11]          -------------------------→ [9]

             Heap after deleting 14                            Max Heap

        After swapping the array element 14 with 9 and converting the heap into max-heap, the elements of array are:

        {11, 9, 14, 22, 54, 76, 81, 89}

        In the next step, again we have to delete the root element (11) from the max heap. To delete this node, we have
        to swap it with the last node, i.e. (9). After deleting the root element, we again have to heapify it to convert
        it into max heap.

                               Heapify
                 [9]  -------------------------→ [9]

          Heap after deleting 11               Max Heap

        After swapping the array element 11 with 9 and converting the heap into max-heap, the elements of array are:

        {9, 11, 14, 22, 54, 76, 81, 89}

        Now, heap has only one element left. After deleting it, heap will be empty.

                             Remove 9
                 [9]  -------------------------→ Empty

        After completion of sorting, the array elements are:

        {9, 11, 14, 22, 54, 76, 81, 89}

        Now, the array is completely sorted.

        Best Case -> O(n log n);
        Average Case -> O(n log n);
        Worst Case -> O(n log n);

        The time complexity of heap sort is O(n log n) in all three cases (best case, average case, and worst case).
        The height of a complete binary tree having n elements is log n.

        Space Complexity -> O(1);
        Stable -> No;

        */

        int[] a = {45, 7, 20, 40, 25, 23, -2};
        System.out.print("Before sorting array elements are - \n");
        printArr(a);
        heapSort(a);
        System.out.print("\nAfter sorting array elements are - \n");
        printArr(a);
    }

    /* function to heapify a subtree. Here 'i' is the
    index of root node in array a[], and 'n' is the size of heap. */
    static void heapify(int[] a, int n, int i)
    {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child
        // If left child is larger than root
        if (left < n && a[left] > a[largest])
            largest = left;
        // If right child is larger than root
        if (right < n && a[right] > a[largest])
            largest = right;
        // If root is not largest
        if (largest != i) {
            // swap a[i] with a[largest]
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            heapify(a, n, largest);
        }
    }

    /*Function to implement the heap sort*/
    static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, arr.length, i);

        // One by one extract an element from heap
        for (int i = arr.length - 1; i >= 0; i--) {
            /* Move current root element to end*/
            // swap a[0] with a[i]
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void printArr(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
    }
}
