package ex14499;

/*
문제 이름: 주사위 굴리기
알고리즘: 구현, 시뮬레이션
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int y = Integer.parseInt(input[2]);
        int x = Integer.parseInt(input[3]);
        int k = Integer.parseInt(input[4]);

        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        // 이동칸이 0이면 주사위 바닥면에 있는 수가 칸에 복사
        // 0이 아니라면 칸에 쓰여있는 수가 주사위 바닥에 복사, 칸에 쓰여있는 수는 0
        // 올바른 이동이라면 상단에 쓰여있는 값 출력
        int[] dice = {0, 0, 0, 0, 0, 0}; //  맨위, 상, 좌, 우, 하, 맨 아래
        input = br.readLine().split(" ");
        for(int i = 0; i < k; i++) {
            int cmd = Integer.parseInt(input[i]);
            int[] copy = dice.clone();
            boolean isCorrect = false;
            if(cmd == 1 && x < m - 1) {
                x += 1;
                copy[0] = dice[2];
                copy[2] = dice[5];
                copy[3] = dice[0];
                copy[5] = dice[3];
                isCorrect = true;
            } else if(cmd == 2 && x > 0) {
                x -= 1;
                copy[0] = dice[3];
                copy[2] = dice[0];
                copy[3] = dice[5];
                copy[5] = dice[2];
                isCorrect = true;
            } else if(cmd == 3 && y > 0) {
                y -= 1;
                copy[0] = dice[4];
                copy[1] = dice[0];
                copy[4] = dice[5];
                copy[5] = dice[1];
                isCorrect = true;
            } else if(cmd == 4 && y < n - 1) {
                y += 1;
                copy[0] = dice[1];
                copy[1] = dice[5];
                copy[4] = dice[0];
                copy[5] = dice[4];
                isCorrect = true;
            }

            if(!isCorrect) {
                continue;
            }

            dice = copy.clone();

            if(map[y][x] == 0) {
                map[y][x] = dice[5];
                bw.write(dice[0] + "\n");
            } else {
                dice[5] = map[y][x];
                map[y][x] = 0;
                bw.write(dice[0] + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
