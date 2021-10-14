package ex2457;

/*
문제 이름: 공주님의 정원
알고리즘: 그리디, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] flower = new int[n][2];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]) * 100 + Integer.parseInt(input[1]);
            int end = Integer.parseInt(input[2]) * 100 + Integer.parseInt(input[3]);

            flower[i][0] = start;
            flower[i][1] = end;
        }

        // 피는 월로 오름차순 같다면 일로 오름차순 정렬
        Arrays.sort(flower, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int endDay = 301;
        if(flower[0][0] > endDay) {
            System.out.println(0);
            return;
        }
        int cnt = 0;
        int i = 0;
        while(endDay <= 1130) {
            int nowEndDay = 0;
            for(; i < n; i++) {
                if(flower[i][0] >= flower[i][1]) {
                    continue;
                }
                if(endDay >= flower[i][0]) {
                    if(nowEndDay < flower[i][1]) {
                        nowEndDay = flower[i][1];
                    }
                } else {
                    break;
                }
            }
            if(nowEndDay == 0) {
                break;
            } else {
                endDay = nowEndDay;
                cnt++;
            }
        }

        if(endDay < 1201) {
            bw.write(0 + "\n");
        } else {
            bw.write(cnt + "\n");
        }
        br.close();
        bw.close();
    }
}
