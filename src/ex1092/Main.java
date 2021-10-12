package ex1092;

/*
문제 이름: 배
알고리즘: 그리디, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] crane = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            crane[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(crane);

        int m = Integer.parseInt(br.readLine());
        int[] box = new int[m];
        input = br.readLine().split(" ");
        for(int j = 0; j < m; j++) {
            box[j] = Integer.parseInt(input[j]);
        }
        Arrays.sort(box);

        if(crane[n - 1] < box[m - 1]) {
            System.out.println(-1);
            return;
        }

        boolean[] isCarried = new boolean[m];
        int result = 0;
        while(true) {
            boolean isComplete = true;
            for(int i = 0; i < m; i++) {
                if(!isCarried[i]) {
                    isComplete = false;
                    break;
                }
            }

            if(isComplete) {
                break;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (crane[i] < box[j]) {
                        for (int k = j - 1; k >= 0; k--) {
                            if (!isCarried[k]) {
                                isCarried[k] = true;
                                break;
                            }
                        }
                        break;
                    }
                    else if(j == m - 1) {
                        for(int k = j; k>= 0; k--) {
                            if (!isCarried[k]) {
                                isCarried[k] = true;
                                break;
                            }
                        }
                    }
                }
            }
            result++;
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
