package ex1822;

/*
문제 이름: 차집합
알고리즘: 정렬
자료구조: 해시셋, 배열리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashSet<Integer> set = new HashSet<>();
        input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(input[i]));
        }

        input = br.readLine().split(" ");
        for(int i = 0; i < m; i++) {
            if(set.contains(Integer.parseInt(input[i]))) {
                set.remove(Integer.parseInt(input[i]));
            }
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        bw.write(list.size() + "\n");
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            result.append(list.get(i) + " ");
        }

        bw.write(result.toString() + "\n");

        br.close();
        bw.close();
    }
}
