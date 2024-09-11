package Searching.LinearSearch.RangeSearch;

public class SearchRange {
    public static void main(String[] args) {
        int[] arr = {18, 9, 12, -7, 3, 70, 43};
        int target = -7, start = 1, end = 4;

        System.out.println(linearSearch(arr, target, start, end));
    }

    static int linearSearch(int[] arr, int target, int start, int end) {

        for (int i = start; i <= end; i++) {
            int el = arr[i];
            if (el == target) {
                return i;
            }
        }

        return Integer.MIN_VALUE;
    }

}
