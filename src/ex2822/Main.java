package ex2822;

/*
문제 이름: 점수 계산
알고리즘: 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 8;
        int[][] score = new int[n][2];

        for (int i = 0; i < n; i++) {
            score[i][0] = Integer.parseInt(br.readLine());
            score[i][1] = i + 1;
        }

        Arrays.sort(score, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int m = 5;
        int[] result = new int[m];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            result[i] = score[i + 3][1];
            sum += score[i + 3][0];
        }

        Arrays.sort(result);

        bw.write(sum + "\n");
        for (Integer idx : result) {
            bw.write(idx + " ");
        }
        br.close();
        bw.close();
    }
}
