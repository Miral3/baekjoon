package ex1268;

/*
문제 이름: 임시 반장 정하기
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][]map = new int[n][5];
        int[] num;
        int[] student = new int[n];
        boolean[][] checked = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < n; i++) {
            checked[i][i] = true;
        }

        for(int i = 0; i < 5; i++) {
            num = new int[10];
            for(int j = 0; j < n; j++) {
                num[map[j][i]]++;
            }
            for(int k = 0; k < n; k++) {
                if(num[map[k][i]] > 1) {
                    for(int l = 0; l < n; l++) {
                        if(map[k][i] == map[l][i]) {
                            if(!checked[k][l]) {
                                checked[k][l] = true;
                                student[k]++;
                            }
                        }
                    }
                }
            }
        }

        int max = -1;
        int result = 0;
        for(int i = 0; i < n; i++) {
            if(max < student[i]) {
                max = student[i];
                result = i + 1;
            }
        }

        System.out.println(result);

        br.close();
        bw.close();
    }
}
