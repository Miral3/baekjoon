package ex1158;

/*
문제 이름: 요세푸스 문제
알고리즘: 연결 리스트
자료구조: 연결 리스트
*/

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        int idx = 0;
        bw.write("<");
        while(!list.isEmpty()) {
            idx = (idx + (k - 1) ) % list.size();
            bw.write(list.remove(idx) + "");
            if(list.size() != 0) {
                bw.write(", ");
            }
        }
        bw.write(">");

        br.close();
        bw.close();
    }
}
