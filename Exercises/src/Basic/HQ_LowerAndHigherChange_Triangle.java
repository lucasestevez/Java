package Basic;

import java.util.Arrays;

public class HQ_LowerAndHigherChange_Triangle {
    public static void main(String[] args) {
        int[][] hq1 = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                if(i == j)
                    hq1[i][j] = 2;
                else
                    hq1[i][j] = 1;
            }
        }
        System.out.println("---Before---");
        for (int[] i : hq1)
            System.out.println(Arrays.toString(i));
        System.out.println();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(hq1[i][j] == 1)
                    hq1[i][j] = 0;
                else if (hq1[i][j] == 0)
                    hq1[i][j] = 1;
            }
        }
        System.out.println("---After---");
        for (int[] i : hq1)
            System.out.println(Arrays.toString(i));



    }
}
