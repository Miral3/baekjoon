package ex1235;

/*
문제 이름: 학생 번호
알고리즘: 구현, 문자열
자료구조: 문자열
*/

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int len = arr[0].length();
        for(int i = 1; i < len + 1; i++) {
            HashSet<String> set = new HashSet<>();
            int j = 0;
            for(j = 0; j < n; j++) {
                if(set.contains(arr[j].substring(len - i))) {
                    break;
                } else {
                    set.add(arr[j].substring(len - i));
                }
            }
            if(j == n) {
                System.out.println(i);
                return;
            }
        }

        br.close();
        bw.close();
    }
}
