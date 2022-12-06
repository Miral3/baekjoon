package ex1593;

/*
문제 이름: 문자 해독
알고리즘: 슬라이딩 윈도우
자료구조: 해시맵
*/

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int wl = Integer.parseInt(input[0]);
        int sl = Integer.parseInt(input[1]);
        String w = br.readLine();
        String s = br.readLine();
        HashMap<Character, Integer> wMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        int left = 0;
        int right = wl;
        int answer = 0;
        for (int i = 0; i < wl; i++) {
            wMap.put(w.charAt(i), wMap.getOrDefault(w.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = right; i <= sl; i++) {
            if (check(wMap, sMap)) {
                answer++;
            }
            if (i == sl) {
                break;
            }
            char prev = s.charAt(left);
            char next = s.charAt(i);
            sMap.put(prev, sMap.get(prev) - 1);
            if (sMap.get(prev) == 0) {
                sMap.remove(prev);
            }
            sMap.put(next, sMap.getOrDefault(next, 0) + 1);
            left++;
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    public static boolean check (HashMap<Character, Integer> wMap, HashMap<Character, Integer> sMap) {
        for (Character key : wMap.keySet()) {
            int value = wMap.get(key);
            if (!sMap.containsKey(key) || sMap.get(key) < value) {
                return false;
            }
        }
        return true;
    }
}
