package ex11478;

/*
문제 이름: 서로 다른 부분 문자열의 개수
알고리즘: 문자열
자료구조: 해시 셋
*/

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j < s.length() + 1; j++) {
                set.add(s.substring(i, j));
            }
        }

        System.out.println(set.size());

        br.close();
        bw.close();
    }
}
