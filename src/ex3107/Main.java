package ex3107;

/*
문제 이름: IPv6
알고리즘: 구현, 문자열
자료구조: 문자열, 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(":");
        StringBuilder answer = new StringBuilder();
        int len = input.length;

        if(len == 0) {
            answer = new StringBuilder("0000:0000:0000:0000:0000:0000:0000:0000");
            System.out.println(answer);
            return;
        }
        else if(len == 1) {
            String str = input[0];
            if(input[0].length() < 4) {
                int size = input[0].length();
                for(int i = 0; i < 4 - size; i++) {
                    str = "0" + str;
                }
            }
            answer = new StringBuilder(str + ":0000:0000:0000:0000:0000:0000:0000");
            System.out.println(answer);
            return;
        }
        int cnt = 0;
        for(int i = 0; i < len; i++) {
            if(input[i].equals("")) {
                if(i == 0) {
                    for(int j = 0; j < 8 - (len-2); j++) {
                        answer.append("0000:");
                        cnt++;
                    }
                    i = 2;
                } else {
                    for(int j = 0; j < 8 - (len - 1); j++) {
                        answer.append("0000:");
                        cnt++;
                    }
                    i++;
                }
            }
            if(input[i].length() < 4) {
                int size = input[i].length();
                for(int j = 0; j < 4 - size; j++) {
                    input[i] = "0" + input[i];
                }
            }

            if(cnt == 7) {
                answer.append(input[i]);

            } else {
                answer.append(input[i] + ":");
                cnt++;
            }
        }

        String[] arr = answer.toString().split(":");
        int size = arr.length;
        if(size < 8) {
            for(int i = size; i < 8; i++) {
                if(size == 7) {
                    answer.append("0000");
                }
                else {
                    answer.append("0000:");
                }
            }
        }

        System.out.println(answer.toString());

        br.close();
        bw.close();
    }
}
