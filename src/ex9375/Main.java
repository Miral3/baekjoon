package ex9375;

/*
문제 이름: 패션왕 신해빈
알고리즘: 수학, 해시
자료구조: 해시 맵
*/

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int result = 1;
            HashMap<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                String type = input[1];

                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            for (String key : map.keySet()) {
                result *= map.get(key) + 1;
            }

            result -= 1;
            bw.write(result + "\n");
        }

        br.close();
        bw.close();
    }
}
