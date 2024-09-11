package Searching.BinarySearch.FindMountainArray;

public class SearchMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 7, 20, 47, 68, 120, 500, 450, 300, 220, 128, 67, 26, 12, 5, 0};
        System.out.println(peakIndexInMountainArray(arr));
    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }


}
