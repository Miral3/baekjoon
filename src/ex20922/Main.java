package ex20922;

/*
문제 이름: 겹치는 건 싫어
알고리즘: 두 포인터
자료구조: 해시 맵
*/

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int left = 0;
        int right = 0;
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap();
        while(left < n && right < n) {
            int prev = arr[left];
            int cur = arr[right];
            if (map.containsKey(cur) && map.get(cur) == k) {
                map.put(prev, map.get(prev) - 1);
                if (map.get(prev) == 0) {
                    map.remove(prev);
                }
                left++;
            } else {
                right++;
                answer = Math.max(answer, right - left);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
