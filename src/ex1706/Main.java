package ex1706;

/*
문제 이름: 크로스워드
알고리즘: 구현, 문자열, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] input2 = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input2[j];
            }
        }

        boolean[][] rowCheck = new boolean[n][m];
        boolean[][] columnCheck = new boolean[n][m];
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!rowCheck[i][j]) {
                    String temp = "";

                    for (int k = j; k < m; k++) {
                        if (map[i][k] == '#') {
                            break;
                        }
                        temp += map[i][k];
                        rowCheck[i][k] = true;
                    }

                    if (temp.length() < 2) {
                        continue;
                    }

                    words.add(temp);
                }
                if (!columnCheck[i][j]) {
                    String temp = "";

                    for (int k = i; k < n; k++) {
                        if (map[k][j] == '#') {
                            break;
                        }
                        temp += map[k][j];
                        columnCheck[k][j] = true;
                    }

                    if (temp.length() < 2) {
                        continue;
                    }

                    words.add(temp);
                }
            }
        }

        Collections.sort(words);

        bw.write(words.get(0) + "\n");
        br.close();
        bw.close();
    }
}
