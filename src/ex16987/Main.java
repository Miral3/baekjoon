package ex16987;

/*
문제 이름: 계란으로 계란치기
알고리즘: 백트래킹, 브루트포스
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n;
    static int[][] eggs;
    static int ans = 0;
    static boolean[] isBroken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        eggs = new int[n][2];
        isBroken = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int durability = Integer.parseInt(input[0]);
            int weight = Integer.parseInt(input[1]);

            eggs[i][0] = durability;
            eggs[i][1] = weight;
        }

        backTracking(0);

        bw.write(ans + "\n");
        br.close();
        bw.close();
    }

    public static void backTracking(int cur) {
        if (cur >= n) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (eggs[i][0] <= 0) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
            return;
        }
        if (eggs[cur][0] <= 0) {
            backTracking(cur + 1);
        } else {
            boolean isHit = false;
            for (int i = 0; i < n; i++) {
                if (i == cur || eggs[i][0] <= 0) {
                    continue;
                }

                eggs[cur][0] -= eggs[i][1];
                eggs[i][0] -= eggs[cur][1];
                isHit = true;
                backTracking(cur + 1);
                eggs[cur][0] += eggs[i][1];
                eggs[i][0] += eggs[cur][1];
            }
            if (!isHit) {
                backTracking(cur + 1);
            }
        }
    }
}
