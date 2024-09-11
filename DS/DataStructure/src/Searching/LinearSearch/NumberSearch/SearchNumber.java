package Searching.LinearSearch.NumberSearch;

public class SearchNumber {
    public static void main(String[] args) {

        int[] nums = {20, 50, 2, 3, 79, 12, -20, -12, 200, 9};
        int target = -12;

        System.out.println(linearSearch(nums, target));
    }

    static int linearSearch(int[] arr, int target) {

        for (int element : arr) {
            if (element == target) {
                return element;
            }
        }

        return Integer.MAX_VALUE;
    }
}
