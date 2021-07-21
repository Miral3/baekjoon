package ex15666;

/*
문제 이름: N과 M (12)
알고리즘: 백트래킹
자료구조: 배열, 연결 해시 셋
*/

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Main {
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int r = Integer.parseInt(input1[1]);
        int[] arr = new int[n];
        int[] output = new int[n];
        boolean[][] visited = new boolean[n][n];

        String[] input2 = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(arr);

        perm(arr, output, visited, 0, n, r);

        for(String s : set) {
            System.out.println(s);
        }

        br.close();
        bw.close();
    }

    public static void perm(int[] arr, int[] output, boolean[][] visited, int depth, int n, int r) {
        if(depth == r) {
            String result = "";
            for(int i = 0; i < r; i++) {
                result += output[i] + " ";
            }
            set.add(result);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[depth][i] != true) {
                visited[depth][i] = true;
                output[depth] = arr[i];
                if(depth == 0) {
                    perm(arr, output, visited, depth + 1, n, r);
                } else {
                    if(output[depth] >= output[depth - 1]) {
                        perm(arr, output, visited, depth + 1, n, r);
                    }
                }
                visited[depth][i] = false;
            }
        }
    }
}
