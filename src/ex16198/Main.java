package ex16198;

/*
문제 이름: 에너지 모으기
알고리즘: 백트래킹
자료구조: 연결 리스트
*/

import java.io.*;
import java.util.LinkedList;

public class Main {
    static int n;
    static int ans = 0;
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(input[i]));
        }

        backTracking(0, 0);

        bw.write(ans + "\n");
        br.close();
        bw.close();
    }
    public static void backTracking(int depth, int sum) {
        if (depth == n - 2) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 1; i < list.size() - 1; i ++) {
            int value = list.get(i);
            int result = list.get(i - 1) * list.get(i + 1);

            sum += result;
            list.remove(i);

            backTracking(depth + 1, sum);

            sum -= result;
            list.add(i, value);
        }
    }
}
