package Basic;

import java.util.Arrays;

public class HQ_0_1 {
    public static void main(String[] args) {

        int[][] hq = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 ; j++) {
                if (i == j) {
                    hq[i][j] = 1;
                } else {
                    hq[i][j] = 0;
                }
            }
        }
        for(int[] i:hq)
            System.out.println(Arrays.toString(i));
    }
}
/*
 * 1   0   0   0   0
 * 0   1   0   0   0
 * 0   0   1   0   0
 * 0   0   0   1   0
 * 0   0   0   0   1
 * */
