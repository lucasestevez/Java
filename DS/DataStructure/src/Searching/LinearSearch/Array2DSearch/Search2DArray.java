package Searching.LinearSearch.Array2DSearch;

import java.util.Arrays;

public class Search2DArray {
    public static void main(String[] args) {
        int[][] arr = {
            {23, 2, 1},
            {14, 50, 70, 3},
            {34, 12, 89, 56},
            {18, 76}
        };
        int target = 18;
        int[] ans = linearSearch(arr, target);
        System.out.println(Arrays.toString(ans));
        System.out.println(max(arr));
        System.out.println(min(arr));
    }

    static int[] linearSearch(int[][] arr, int target) {

        for (int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[] {row, col};
                }
            }
        }

        return new int[] {-1, -1};
    }

    static int max(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int[] numbers : arr) {
            for (int element : numbers) {
                if (element > max)
                    max = element;
            }
        }
        return max;
    }

    static int min(int[][] arr) {
        int min = Integer.MAX_VALUE;
        for (int[] numbers : arr) {
            for (int element : numbers) {
                if (element < min)
                    min = element;
            }
        }
        return min;
    }
}
