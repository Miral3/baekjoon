package ex2116;

/*
문제 이름: 주사위 쌓기
알고리즘: 구현, 브루트포스
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dice = new int[n][6];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(input[j]);
            }
        }

        int max = 0;
        for(int i = 0; i < 6; i++) { // 첫 번째 주사위의 윗면으로 사용할 모든 숫자를 반복
            int sum = 0;
            int ceil = i;
            sum = getMax(i, dice, 0);
            for(int j = 1; j < n; j++) { // 첫 번째 주사위의 맨 위 숫자가 정해지면 나머지 주사위 확인
                int k = 0;
                for(k = 0; k < 6; k++) { // 나머지 주사위의 6면을 돌면서 n-1번 째 주사위의 윗면과 자신의 아랫면을 일치시킨다.
                    if (dice[j - 1][ceil] == dice[j][k]) {
                        sum += getMax(k, dice, j);
                        break;
                    }
                }
                switch (k) {
                    case 0:
                        ceil = 5;
                        break;
                    case 1:
                        ceil = 3;
                        break;
                    case 2:
                        ceil = 4;
                        break;
                    case 3:
                        ceil = 1;
                        break;
                    case 4:
                        ceil = 2;
                        break;
                    case 5:
                        ceil = 0;
                        break;
                }
            }
            max = Math.max(max, sum);
        }

        bw.write(max + "\n");

        br.close();
        bw.close();
    }

    public static int getMax(int i, int[][] dice, int idx) {
        int max = 0;
        for(int j = 0; j < 6; j++) { // 맨 위, 아래로 선택한 숫자를 제외한 숫자들 중 최대값을 찾음
            if(i == 0 || i == 5) {
                if(j == 5 || j == 0) {
                    continue;
                }
            } else if(i == 1 || i == 3) {
                if(j == 1 || j == 3) {
                    continue;
                }
            } else if(i == 2 || i == 4) {
                if(j == 2 || j == 4) {
                    continue;
                }
            }
            max = Math.max(dice[idx][j], max);
        }

        return max;
    }
}
