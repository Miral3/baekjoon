package ex2109;

/*
문제 이름: 순회강연
알고리즘: 그리디, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        int[] pay = new int[10001];
        for(int i = 0; i < n; i++) {
            int p = arr[i][0];
            int d = arr[i][1];

            for(int j = d; j >= 1; j--) {
                if(pay[j] < p) {
                    pay[j] = p;
                    break;
                }
            }
        }

        int result = 0;
        for(Integer val : pay) {
            result += val;
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
