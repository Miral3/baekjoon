package ex17219;

/*
문제 이름: 비밀번호 찾기
알고리즘: 해시 맵
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
        int m = Integer.parseInt(input[1]);

        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            String site = input[0];
            String password = input[1];

            map.put(site, password);
        }

        for(int i = 0; i < m; i++) {
            String input2 = br.readLine();
            bw.write(map.get(input2) + "\n");
        }

        br.close();
        bw.close();
    }
}
