package ex17829;

/*
문제 이름: 222-풀링
알고리즘: 분할 정복
자료구조: 배열, 연결 리스트
*/

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    static int[][] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        bw.write(dfs(n / 2, 0, 0) + "\n");
        br.close();
        bw.close();
    }
    public static int dfs(int half, int y, int x) {
        LinkedList<Integer> list = new LinkedList<>();
        if (half == 1) {
            list.add(arr[y][x]);
            list.add(arr[y][x + 1]);
            list.add(arr[y + 1][x]);
            list.add(arr[y + 1][x + 1]);
            Collections.sort(list);
            return list.get(2);
        } else {
            list.add(dfs(half / 2, y, x));
            list.add(dfs(half / 2, y, x + half));
            list.add(dfs(half / 2, y + half, x));
            list.add(dfs(half / 2, y + half, x + half));
            Collections.sort(list);
            return list.get(2);
        }
    }
}
