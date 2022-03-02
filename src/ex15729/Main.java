package ex15729;

/*
문제 이름: 방탈출
알고리즘: 그리디 알고리즘
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] target = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(input[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != target[i]) {
                ans++;
                for (int j = i; j < i + 3; j++) {
                    if (j < n) {
                        if (arr[j] == 1) {
                            arr[j] = 0;
                        } else {
                            arr[j] = 1;
                        }
                    }
                }
            }
        }

        bw.write(ans + "\n");
        br.close();
        bw.close();
    }
}
