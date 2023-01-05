package ex17264;

/*
문제 이름: I AM IRONMAN
알고리즘: 구현
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
        int p = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int w = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);
        int g = Integer.parseInt(input[2]);

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < p; i++) {
            input = br.readLine().split(" ");
            map.put(input[0], input[1]);
        }

        int score = 0;
        boolean isIron = true;
        for (int i = 0; i < n; i++) {
            String player = br.readLine();

            if (score < 0) {
                score = 0;
            }

            if (!map.containsKey(player)) {
                score -= l;
                continue;
            }

            String result = map.get(player);
            if (result.equals("W")) {
                score += w;
            } else {
                score -= l;
            }

            if (score >= g) {
                isIron = false;
                break;
            }
        }

        if (isIron) {
            bw.write("I AM IRONMAN!!\n");
        } else {
            bw.write("I AM NOT IRONMAN!!\n");
        }
        br.close();
        bw.close();
    }
}
