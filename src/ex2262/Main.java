package ex2262;

/*
문제 이름: 토너먼트 만들기
알고리즘: 그리디
자료구조: 연결 리스트
*/

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();
        String[] input = br.readLine().split(" ");
        for(String str : input) {
            list.add(Integer.parseInt(str));
        }

        int result = 0;
        while(list.size() > 1) {
            int size = list.size();
            int max = 0;
            for(Integer v : list) {
                max = Math.max(v, max);
            }
            int idx = list.indexOf(max);
            if(idx == 0) {
                result += list.get(idx) - list.get(idx + 1);
            } else if(idx == size - 1) {
                result += list.get(idx) - list.get(idx - 1);
            } else {
                if(list.get(idx - 1) > list.get(idx + 1)) {
                    result += list.get(idx) - list.get(idx - 1);
                } else {
                    result += list.get(idx) - list.get(idx + 1);
                }
            }
            list.remove(idx);
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
