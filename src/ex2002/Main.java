package ex2002;

/*
문제 이름: 추월
알고리즘: 구현, 해시맵
자료구조: 해시맵
*/

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(br.readLine(), i);
        }

        int[] out = new int[n];
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            out[i] = map.get(input);
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(out[i] > out[j]) {
                    result++;
                    break;
                }
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
