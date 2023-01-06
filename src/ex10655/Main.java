package ex10655;

/*
문제 이름: 마라톤 1
알고리즘: 구현, 브루트포스, 기하학
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] max = new int[2];
        int[][] pos = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            pos[i][0] = x;
            pos[i][1] = y;
        }

        for (int i = 1; i < n - 1; i++) {
            int oneDis = Math.abs(pos[i-1][0] - pos[i+1][0]) + Math.abs(pos[i-1][1] - pos[i+1][1]);
            int twoDis = (Math.abs(pos[i-1][0] - pos[i][0]) + Math.abs(pos[i-1][1] - pos[i][1])) +
                (Math.abs(pos[i][0] - pos[i+1][0]) + Math.abs(pos[i][1] - pos[i+1][1]));
            int dis = twoDis - oneDis;
            if (max[1] < dis) {
                max[0] = i;
                max[1] = dis;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (i != 0 && i == max[0]) {
                continue;
            }
            if (i + 1 == max[0]) {
                int dis = Math.abs(pos[i][0] - pos[i+2][0]) + Math.abs(pos[i][1] - pos[i+2][1]);
                answer += dis;
            } else {
                int dis = Math.abs(pos[i][0] - pos[i+1][0]) + Math.abs(pos[i][1] - pos[i+1][1]);
                answer += dis;
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
