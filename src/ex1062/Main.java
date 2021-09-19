package ex1062;

/*
문제 이름: 가르침
알고리즘: 브루트포스, 백트래킹
자료구조: 배열, 불리언
*/

import java.io.*;

public class Main {
    static boolean[] isLearned;
    static char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static char[][] arr;
    static char[] out;
    static int n, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        // k가 5보다 작으면 접두사 접미사를 못배우기 때문에 0을 return
        if(k < 5) {
            System.out.println(0);
            return;
        }

        char[] south = {'a', 'c', 'i', 'n', 't'}; // 접두사 접미사
        int len = k - 5; // k - 접두사 접미사 알파뱃 개수
        isLearned = new boolean[27]; // 학습한 알파벳 저장
        for(int i = 0; i < 5; i++) {
            isLearned[south[i] - 'a'] = true;
        }


        arr = new char[n][16]; // n개의 단어에서 접두사 접미사 사이의 알파뱃을 2차원 char배열에 저장
        for(int i = 0; i < n; i++) { // 접두사 접미사 사이의 단어 크기 이상을 돌 필요가 없으므로 나중에 조건문에 걸리도록 A로 초기화
            for(int j = 0; j < 16; j++) {
                arr[i][j] = 'A';
            }
        }
        // 접두사 접미사 사이의 단어를 arr배열에 저장
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] charArr = str.toCharArray();
            int idx = 0;
            for(int j = 4; j < str.length() - 4; j++) {
                arr[i][idx++] = charArr[j];
            }
        }

        out = new char[len];
        backTracking(len, 0, 0);

        bw.write(max + "\n");

        br.close();
        bw.close();
    }

    public static void backTracking(int len, int depth, int start) {
        // 깊이가 len 일 때
        if(depth == len) {
            int cnt = 0;
            // arr을 돌면서
            for(int i = 0; i < n; i++) {
                boolean isCorrect = true;
                for(int j = 0; j < arr[i].length; j++) {
                    // A이면(= 접두사 접미사 사이의 단어가 아닐 때) break
                    if(arr[i][j] == 'A') {
                        break;
                    }
                    // 배우지 않은 단어이면 isCorrect를 false로 하고 break
                    if(!isLearned[arr[i][j] - 'a']) {
                        isCorrect = false;
                        break;
                    }
                }
                // arr[i]를 다 돌고 isCorrect가 true면 cnt를 증가
                if(isCorrect) {
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
            return;
        }

        for(int i = start; i < alpha.length; i++) {
            if(!isLearned[alpha[i] - 'a']) {
                isLearned[alpha[i] - 'a'] = true;
                backTracking(len, depth + 1, i + 1);
                isLearned[alpha[i] - 'a'] = false;
            }
        }
    }
}
