package ex11004;

/*
문제 이름: k번째 수
알고리즘: 정렬
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        ArrayList<Integer> list = new ArrayList<>();
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(input[i]));
        }
        Collections.sort(list);
        bw.write(list.get(k-1) + "\n");
        br.close();
        bw.close();
    }
}
