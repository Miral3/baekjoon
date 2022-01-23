package ex15787;

/*
문제 이름: 기차가 어둠을 헤치고 은하수를
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] train = new int[n + 1][21];
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int cmd = Integer.parseInt(input[0]);
            int idx = Integer.parseInt(input[1]);
            int x = 0;

            if (cmd == 1) {
                x = Integer.parseInt(input[2]);
                if (train[idx][x] == 0) {
                    train[idx][x] = 1;
                }
            } else if (cmd == 2) {
                x = Integer.parseInt(input[2]);
                if (train[idx][x] == 1) {
                    train[idx][x] = 0;
                }
            } else if (cmd == 3) {
                for (int j = 20; j >= 1; j--) {
                    if(j == 20) {
                        if (train[idx][j] == 1) {
                            train[idx][j] = 0;
                        }
                    } else {
                        if (train[idx][j] == 1) {
                            train[idx][j + 1] = 1;
                            train[idx][j] = 0;
                        }
                    }
                }
            } else if (cmd == 4) {
                for (int j = 1; j <= 20; j++) {
                    if(j == 1) {
                        if (train[idx][j] == 1) {
                            train[idx][j] = 0;
                        }
                    } else {
                        if (train[idx][j] == 1) {
                            train[idx][j - 1] = 1;
                            train[idx][j] = 0;
                        }
                    }
                }
            }
        }

        HashSet<String> set = new HashSet<>();
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1 ; j <= 20; j++) {
                sb.append(train[i][j]);
            }
            if (set.contains(sb.toString())) {
                continue;
            } else {
                set.add(sb.toString());
                answer++;
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
