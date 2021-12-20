package ex1342;

/*
문제 이름: 행운의 문자열
알고리즘: 백트래킹
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int cnt = 0;
    static char[] arr;
    static char[] out;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = br.readLine().toCharArray();
        int len = arr.length;
        out = new char[len];
        isVisited = new boolean[len];

        backTracking(0, len);

        int[] alphabet = new int[26];
        for (int i = 0; i < len; i++) {
            alphabet[arr[i]-'a']++;
        }

        for (int i = 0; i < 26; i ++) {
            if(alphabet[i] > 1) {
                cnt /= factorial(alphabet[i]);
            }
        }

        bw.write(cnt + "\n");
        br.close();
        bw.close();
    }
    public static void backTracking(int depth, int size) {
        if(size == depth) {
            cnt++;
            return;
        }

        for (int i = 0; i < size; i++) {
            if (!isVisited[i]) {

                if(depth > 0 && out[depth-1] == (arr[i])) {
                    continue;
                }

                isVisited[i] = true;
                out[depth] = arr[i];
                backTracking(depth + 1, size);
                isVisited[i] = false;
            }
        }
    }

    public static int factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
