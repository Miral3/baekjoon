package ex5568;

/*
문제 이름: 카드 놓기
알고리즘: 순열
자료구조: 배열, 해시 셋
*/

import java.io.*;
import java.util.HashSet;

public class Main {
    static int n;
    static int k;
    static int[] arr;
    static int[] out;
    static boolean[] isVisited;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        out = new int[k];
        isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        permutation(0);

        bw.write(set.size() + "\n");
        br.close();
        bw.close();
    }

    public static void permutation(int depth) {
        if (depth == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(out[i]);
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                out[depth] = arr[i];
                permutation(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
