package Ex20291;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        String[] arr = new String[testCase];

        /* 파일 입력 */
        for(int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split("[.]");
            arr[i] = input[1];
        }

        Map<String, Integer> map = new TreeMap<>();
        /* 중복 확장자 카운팅 */
        for(String key : arr) {
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        /* 출력 */
        for(String key : map.keySet()){
            Integer value = map.get(key);
            bw.write(key+" "+value + "\n");
        }
        bw.close();
        br.close();
    }
}
