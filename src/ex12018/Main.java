package ex12018;

/*
문제 이름: Yonsei TOTO
알고리즘: 그리디, 정렬
자료구조: 배열, 연결 리스트
*/

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int l = Integer.parseInt(input[1]);


            int[] arr = new int[p];
            input = br.readLine().split(" ");
            for(int j = 0; j < p; j++) {
                arr[j] = Integer.parseInt(input[j]);
            }

            if(l > p) {
                list.add(1);
                continue;
            }

            Arrays.sort(arr);

            int idx = p-l;
            list.add(arr[idx]);
        }

        Collections.sort(list);

        int result = 0;
        for(Integer data : list) {
            m -= data;
            if(m < 0) {
                break;
            } else {
                result++;
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
