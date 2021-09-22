package ex1339;

/*
문제 이름: 단어 수학
알고리즘: 그리디, 브루트포스
자료구조: 해시맵, 배열
*/

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] alphabet = new int[27];
        String[] word = new String[n];

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
            char[] input = word[i].toCharArray();
            for (int j = 0; j < input.length; j++) {
                if (!map.containsKey(input[j])) {
                    map.put(input[j], (int) Math.pow(10, input.length - 1 - j));
                } else {
                    int value = map.get(input[j]);
                    value += Math.pow(10, input.length - 1 - j);
                    map.put(input[j], value);
                }
            }
        }

        List<Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        int idx = 9;
        for (int i = 0; i < list.size(); i++) {
            alphabet[list.get(i).getKey() - 'A'] = idx--;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word[i].length(); j++) {
                char alpha = word[i].charAt(j);
                int num = alphabet[alpha - 'A'];
                sb.append(num);
            }
            if (isNum(sb.toString())) {
                result += Integer.parseInt(sb.toString());
            }
        }
        bw.write(result + "\n");
        br.close();
        bw.close();
    }

    public static boolean isNum(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
