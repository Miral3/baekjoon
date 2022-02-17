package ex20921;

/*
문제 이름: 그렇고 그런 사이
알고리즘: 그리디
자료구조: 덱, 배열
*/

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = new int[n + 1];

        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            que.addLast(i);
        }

        for (int i = 1; i < n; i++) {
            if (k >= n - i) {
                arr[i] =  que.pollLast();
                k -= n - i;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                arr[i] = que.pollFirst();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i] + " ");
        }

        bw.write(sb.toString() + "\n");
        br.close();
        bw.close();
    }
}
