package ex3077;

/*
문제 이름: 임진왜라
알고리즘: 문자열, 브루트포스
자료구조: 해시맵
*/

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] answer = br.readLine().split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(answer[i], i);
        }

        String[] input = br.readLine().split(" ");
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            String value = input[i];
            int num = map.get(value);
            for(int j = i + 1; j < n; j++) {
                if(num < map.get(input[j])) {
                    cnt++;
                }
            }
        }


        bw.write(cnt + "/" + (n * (n - 1)) / 2 +"\n");

        br.close();
        bw.close();
    }
}
