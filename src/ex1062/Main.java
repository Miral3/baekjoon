package ex1062;

/*
문제 이름: 가르침
알고리즘: 브루트포스, 백트래킹
자료구조: 배열
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

        if(k < 5) {
            System.out.println(0);
            return;
        }

        char[] south = {'a', 'c', 'i', 'n', 't'};
        int len = k - 5;
        isLearned = new boolean[27];
        for(int i = 0; i < 5; i++) {
            isLearned[south[i] - 'a'] = true;
        }


        arr = new char[n][16];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 16; j++) {
                arr[i][j] = 'A';
            }
        }
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
        if(depth == len) {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                boolean isCorrect = true;
                for(int j = 0; j < arr[i].length; j++) {
                    if(arr[i][j] == 'A') {
                        break;
                    }
                    if(!isLearned[arr[i][j] - 'a']) {
                        isCorrect = false;
                        break;
                    }
                }
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
