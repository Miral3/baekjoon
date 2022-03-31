package ex1141;

/*
문제 이름: 접두사
알고리즘: 정렬, 문자열
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words);
        int answer = 1;
        for (int i = 0; i < n - 1; i++) {
            if (words[i].length() <= words[i + 1].length()) {
                String splitNextWord = words[i + 1].substring(0, words[i].length());

                if (!words[i].equals(splitNextWord)) {
                    answer++;
                }
            } else {
                answer++;
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
