package ex18870;

/*
문제 이름: 좌표 압축
알고리즘: 정렬, 해시맵, 좌표 압축
자료구조: 해시맵, 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        int[] copy = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            copy[i] = arr[i];
        }
        Arrays.sort(copy);

        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(copy[i])) {
                map.put(copy[i], idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(map.get(arr[i])).append(' ');
        }

        bw.write(sb.toString() + "\n");
        br.close();
        bw.close();
    }
}
