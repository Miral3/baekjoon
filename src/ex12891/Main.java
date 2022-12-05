package ex12891;

/*
문제 이름: DNA 비밀번호
알고리즘: 문자열, 슬라이딩 윈도우
자료구조: 해시맵, 배열
*/

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);

        String[] dna = br.readLine().split("");

        input = br.readLine().split(" ");
        int[] num = new int[4];
        for (int i = 0; i < 4; i++) {
            num[i] = Integer.parseInt(input[i]);
        }

        String[] alpha = {"A", "C", "G", "T"};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            map.put(alpha[i], 0);
        }

        for (int i = 0; i < p; i++) {
            if (map.containsKey(dna[i])) {
                map.put(dna[i], map.get(dna[i]) + 1);
            }
        }

        int left = 0;
        int right = p - 1;
        int answer = 0;
        while (true) {
            boolean isSatisfied = true;
            for (int i = 0; i < 4; i++) {
                if(map.get(alpha[i]) < num[i]) {
                    isSatisfied = false;
                    break;
                }
            }
            if (isSatisfied) {
                answer++;
            }

            if (right == s - 1) {
                break;
            }

            if (map.containsKey(dna[left])) {
                map.put(dna[left], map.get(dna[left]) - 1);
            }
            left++;
            right++;
            if (map.containsKey(dna[right])) {
                map.put(dna[right], map.get(dna[right]) + 1);
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
