package ex7507;

/*
문제 이름: 올림픽 게임
알고리즘: 구현, 그리디, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            int m = Integer.parseInt(br.readLine());
            int[][] gameInfo = new int[m][3];

            for (int j = 0; j < m; j++) {
                String[] input = br.readLine().split(" ");

                gameInfo[j][0] = Integer.parseInt(input[0]); // day
                gameInfo[j][1] = Integer.parseInt(input[1]); // start
                gameInfo[j][2] = Integer.parseInt(input[2]); // end
            }


            Arrays.sort(gameInfo, (o1,  o2) -> {
               if (o1[0] == o2[0]) {
                   if (o1[2] == o2[2]) {
                       return Integer.compare(o1[1], o2[1]);
                   } else {
                       return Integer.compare(o1[2], o2[2]);
                   }
               } else {
                   return Integer.compare(o1[0], o2[0]);
               }
            });


            int prevDate = -1;
            int prevEndTime = 0;
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (prevDate == gameInfo[j][0]) {
                    if (prevEndTime > gameInfo[j][1]) {
                        continue;
                    }
                    count++;
                    prevEndTime = gameInfo[j][2];
                } else {
                    count++;
                    prevDate = gameInfo[j][0];
                    prevEndTime = gameInfo[j][2];
                }
            }

            bw.write("Scenario #" + i + ":" + "\n" + count);
            if (i != n) {
                bw.write("\n\n");
            }
        }

        br.close();
        bw.close();
    }
}
