package ex1759;

/*
문제 이름: 암호 만들기
알고리즘: 백트래킹
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    static int l;
    static int c;
    static String[] vowels = {"a", "e", "i", "o", "u"};
    static String[] arr;
    static String[] out;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        l = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        arr = br.readLine().split(" ");

        Arrays.sort(arr);

        out = new String[l];
        isVisited = new boolean[c];

        backTracking(0);
        br.close();
        bw.close();
    }

    public static void backTracking(int depth) {
        if(depth == l) {
            StringBuilder sb = new StringBuilder();
            int cnt = 0;

            for(int i = 0; i < l; i++) {
                sb.append(out[i]);

                for (int j = 0; j < 5; j++) {
                    if (out[i].equals(vowels[j])) {
                        cnt++;
                        break;
                    }
                }
            }

            if(cnt >= 1 && l - cnt >= 2) {
                System.out.println(sb.toString());
            }
            return;
        }

        for(int i = 0; i < c; i++) {
            if(!isVisited[i]) {
                if(depth == 0) {
                    isVisited[i] = true;
                    out[depth] = arr[i];
                    backTracking(depth + 1);
                    isVisited[i] = false;
                } else {
                    if(out[depth - 1].compareTo(arr[i]) < 0) {
                        isVisited[i] = true;
                        out[depth] = arr[i];
                        backTracking(depth + 1);
                        isVisited[i] = false;
                    }
                }
            }
        }
    }
}
