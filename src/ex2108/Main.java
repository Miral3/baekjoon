package ex2108;

/*
문제 이름: 통계학
알고리즘: 구현, 정렬
자료구조: 배열, 연결 리스트, 해시맵
*/

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[4];
        double sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        result[0] = (int)Math.round(sum / n);
        Arrays.sort(arr);
        result[1] = arr[n / 2];
        result[3] = arr[n - 1] - arr[0];

        Map<Integer, Integer> map = new HashMap<>();
        for(Integer key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(new Comparator<Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                if(o2.getValue() > o1.getValue()) {
                    return 1;
                } else if(o2.getValue() < o1.getValue()) {
                    return -1;
                }
                else {
                    if(o2.getKey() > o1.getKey()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });
        if(list.size() > 1 && list.get(0).getValue() == list.get(1).getValue()) {
            result[2] = list.get(1).getKey();
        } else {
            result[2] = list.get(0).getKey();
        }

        for(int i = 0; i < result.length; i++) {
            bw.write(result[i] + "\n");
        }
        br.close();
        bw.close();
    }
}
