package ex2910;

/*
문제 이름: 빈도 정렬
알고리즘: 구현, 정렬, 연결 해시 맵
자료구조: 연결 해시 맵
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for(Integer key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(map.get(o2), map.get(o1));
            }
        });

        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < map.get(list.get(i)); j++) {
                bw.write(list.get(i) + " ");
            }
        }
        br.close();
        bw.close();
    }
}
