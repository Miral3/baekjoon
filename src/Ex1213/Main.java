package Ex1213;

/*
문제 이름 : 팰린드롬 만들기
알고리즘 : 구현
자료구조 : 문자열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int len = input.length();
        int[] alphabet = new int[26];
        boolean isEven = false;

        if(len % 2 == 0) {
            isEven = true;
        }

        for(int i = 0; i < len; i++) {
            alphabet[input.charAt(i)-'A']++;
        }

        int cnt = 0;
        int midIdx = 0;
        for(int i = 0; i < 26; i++) {
            if(alphabet[i] % 2 != 0) {
                cnt++;
                midIdx = i;
            }
        }

        if(( isEven && cnt > 0 ) || ( !isEven && cnt > 1 )) {
            System.out.println("I'm Sorry Hansoo");
            return;
        } else {
            String ans = "";
            for(int i = 0; i < alphabet.length; i++) {
                for(int j = 0; j < alphabet[i] / 2; j++) {
                    ans += ((char)(i+'A'));
                }
            }
            String rev = reverseString(ans);
            if(cnt==1) {
                ans += ((char)(midIdx + 'A'));
            }
            bw.write(ans + rev + "\n");
        }

        br.close();
        bw.close();
    }
    public static String reverseString(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }
}

