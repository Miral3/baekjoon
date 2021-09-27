package ex16916;

/*
문제 이름: 부분 문자열
알고리즘: 문자열, kmp
자료구조: 문자열, 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String p = br.readLine();

        int[] pi = new int[p.length()];
        getPi(p.split(""), pi);

        KMP(s.split(""), p.split(""), pi);

        br.close();
        bw.close();
    }

    public static void getPi(String[] arr, int[] pi) {
        int j = 0;
        int i = 1;

        while(i < pi.length) {
            if(arr[j].equals(arr[i])) {
                pi[i] = j + 1;
                i++;
                j++;
            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = pi[j - 1];
                }
            }
        }
    }

    public static void KMP(String[] strArr, String[] patternArr, int[] pi) {
        int i = 0;
        int j = 0;
        while(i < strArr.length) {
            if(strArr[i].equals(patternArr[j])) {
                i++;
                j++;
            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = pi[j - 1];
                }
            }

            if(j == patternArr.length) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}
