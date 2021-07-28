package ex1233;

/*
문제 이름: 주사위
알고리즘: 브루트포스, 구현
자료구조: 해시맵
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int s1 = Integer.parseInt(input[0]);
        int s2 = Integer.parseInt(input[1]);
        int s3 = Integer.parseInt(input[2]);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= s1; i++) {
            for(int j = 1; j <= s2; j++) {
                for(int k = 1; k <= s3; k++) {
                    int sum = i +j + k;
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        int max = 0;
        int result = 0;
        for(Integer i : map.keySet()) {
            if(max < map.get(i)) {
                max = map.get(i);
                result = i;
            }
        }

        System.out.println(result);

        br.close();
        bw.close();
    }
}
