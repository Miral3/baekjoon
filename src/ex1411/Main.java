package ex1411;

/*
문제 이름: 비슷한 단어
알고리즘: 구현, 문자열, 브루트포스
자료구조: 문자열
*/

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            int size = input.length;
            ArrayList<Character> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < size; j++) {
                if (list.contains(input[j])) {
                    sb.append(list.indexOf((input[j])));
                } else {
                    list.add(input[j]);
                    sb.append(list.size() - 1);
                }
            }
            result.add(sb.toString());
        }

        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            String cur = result.get(i);
            for (int j = i + 1; j < n; j++) {
                String nxt = result.get(j);
                if (cur.equals(nxt)) {
                    cnt++;
                }
            }
        }

        bw.write(cnt + "\n");
        br.close();
        bw.close();
    }
}
