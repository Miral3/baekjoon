package ex12919;

/*
문제 이름: A와 B 2
알고리즘: 구현, 문자열, 브루트포스, 재귀
자료구조: 문자열
*/

import java.io.*;
import java.util.HashSet;

public class Main {
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();

        dfs(s, t, t.length(), s.length());

        System.out.println(0);

        br.close();
        bw.close();
    }

    public static void dfs(String s, String t, int depth, int len) {
        if(depth == len) {
            if(t.equals(s)) {
                System.out.println(1);
                System.exit(0);
            }
            return;
        }

        String plus = "";
        if(t.charAt(t.length() - 1) == 'A') {
            plus = t.substring(0, t.length()-1);
            if(!set.contains(plus)) {
                set.add(plus);
                dfs(s, plus, depth - 1, len);
            }
        }

        String reverse = "";
        if(t.charAt(0) == 'B') {
            reverse = t.substring(1);
            StringBuilder sb = new StringBuilder(reverse);
            reverse = sb.reverse().toString();

            if(!set.contains(reverse)) {
                set.add(reverse);
                dfs(s, reverse, depth - 1, len);
            }
        }

    }
}
