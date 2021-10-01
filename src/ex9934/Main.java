package ex9934;

/*
문제 이름: 완전 이진 트리
알고리즘: 구현, 트리, 재귀
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int size = (int)Math.pow(2, k) - 1;
        int[] visit = new int[size + 1];

        for(int i = 1; i <= size; i++) {
            visit[i] = Integer.parseInt(input[i - 1]);
        }

        for(int i = 1; i <= k; i++) {
            for(int j = 0; j < (int)Math.pow(2, (i - 1)); j++) {
                bw.write(visit[(int)Math.pow(2, k - i) + ((int)Math.pow(2, k - i + 1) * j)] + " ");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}
