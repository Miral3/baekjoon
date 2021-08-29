package ex10453;

/*
문제 이름: 문자열 변환
알고리즘: 구현, 문자열
자료구조: 문자열
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            String A = input[0];
            String B = input[1];

            if(A.length() != B.length()) {
                bw.write(-1 + "\n");
                continue;
            }

            Queue<Integer> aq = new LinkedList<>();
            Queue<Integer> bq = new LinkedList<>();
            for(int j = 0; j < A.length(); j++) {
                if(A.charAt(j) == 'a') {
                    aq.add(j);
                }
                if(B.charAt(j) == 'a') {
                    bq.add(j);
                }
            }

            int result = 0;
            while(!aq.isEmpty()) {
                result += Math.abs(aq.poll() - bq.poll());
            }
            bw.write(result + "\n");
        }

        br.close();
        bw.close();
    }
}
