package ex7662;

/*
문제 이름: 이중 우선순위 큐
알고리즘: 트리맵
자료구조: 트리맵
*/

import java.io.*;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                String command = input[0];
                int value = Integer.parseInt(input[1]);

                if(command.equals("I")) {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else if(command.equals("D")) {
                    if(map.isEmpty()) {
                        continue;
                    }
                    int num = value == 1 ? map.lastKey() : map.firstKey();
                    if(map.put(num, map.get(num) - 1) == 1) {
                        map.remove(num);
                    }
                }
            }
            bw.write(map.isEmpty() ? "EMPTY\n" : map.lastKey() + " " + map.firstKey() + "\n");
        }

        br.close();
        bw.close();
    }
}
