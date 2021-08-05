package ex3048;

/*
문제 이름: 개미
알고리즘: 구현, 문자열
자료구조: 문자열
*/

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n1 = Integer.parseInt(input[0]);
        int n2 = Integer.parseInt(input[1]);
        String right = br.readLine();
        String left = br.readLine();
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(right);
        String result = sb.reverse().toString() + left;

        for (int i = 1; i <= t; i++) {
            for (int j = 0; j < result.length(); j++) {
                if(left.contains(result.charAt(j) + "")) {
                    if(j == 0) {
                        continue;
                    }
                    if(right.contains(result.charAt(j - 1) + "")) {
                        result = swap(result, j, j - 1);
                        j++;
                    }
                }
            }
        }

        System.out.println(result);

        br.close();
        bw.close();
    }

    public static String swap(String str, int i, int j) {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;

        return String.valueOf(ch);
    }
}
