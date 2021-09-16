package ex1254;

/*
문제 이름: 팰린드롬 만들기
알고리즘: 문자열, 브루트포스
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int min = 2001;
        if(isPalindrome(s)) {
            System.out.println(s.length());
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s.substring(0, s.length() - i));
            String reverse = sb.reverse().toString();
            sb.setLength(0);
            sb.append(s);
            sb.append(reverse);
            if(isPalindrome(sb.toString())) {
                min = Math.min(min, sb.length());
            }
        }

        System.out.println(min);
        br.close();
        bw.close();
    }
    public static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder();
        if(str.length() % 2 == 0) {
            if(str.substring(0, str.length() / 2)
                .equals(sb.append(str.substring(str.length() / 2)).reverse().toString())) {
                return true;
            }
        } else {
            if(str.substring(0, str.length() / 2)
                .equals(sb.append(str.substring((str.length() / 2) + 1)).reverse().toString())) {
                return true;
            }
        }
        return false;
    }
}
