package ex10867;

/*
문제 이름: 중복 빼고 정렬하기
알고리즘: 정렬
자료구조: 트리 셋
*/

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(input[i]));
        }

        for (Integer num : set) {
            bw.write(num + " ");
        }

        br.close();
        bw.close();
    }
}
