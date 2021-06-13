package Ex1120;

/*
문제 이름 : 문자열
알고리즘 : 문자열, 브루트포스
자료구조 : 문자열
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        String A = input[0];
        String B = input[1];
        int dif = B.length() - A.length();

        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= dif; i++) {
            int cnt = 0;
            for(int j = 0; j < A.length(); j++) {
                if(A.charAt(j) != B.charAt(j + i)) {
                    cnt++;
                }
            }
            if(cnt < min) {
                min = cnt;
            }
        }

        System.out.println(min);

        br.close();
    }
}
