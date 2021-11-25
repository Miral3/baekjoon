package ex19621;

/*
문제 이름: 회의실 배정 2
알고리즘: 다이나믹 프로그래밍, 재귀
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n;
    static int result = 0;
    static int[][] meetingRoom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        meetingRoom = new int[n][3];

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int personnel = Integer.parseInt(input[2]);

            meetingRoom[i][0] = start;
            meetingRoom[i][1] = end;
            meetingRoom[i][2] = personnel;
        }

        dfs(0, 0);

        bw.write(result + "\n");
        br.close();
        bw.close();
    }

    public static void dfs(int i, int sum) {
        if(i > n-1) {
            result = Math.max(result, sum);
            return;
        }

        dfs(i + 1, sum);
        dfs(i + 2, sum + meetingRoom[i][2]);
    }
}
