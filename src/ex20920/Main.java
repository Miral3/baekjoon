package ex20920;

/*
문제 이름: 영단어 암기는 괴로워
알고리즘: 문자열, 정렬, 해시 맵
자료구조: 해시 맵
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> map = new HashMap<>();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if (str.length() >= m) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                if(o2.getValue() > o1.getValue()) {
                    return 1;
                } else if(o2.getValue() < o1.getValue()) {
                    return -1;
                } else {
                    if(o2.getKey().length() > o1.getKey().length()) {
                        return 1;
                    } else if(o2.getKey().length() < o1.getKey().length()) {
                        return -1;
                    } else {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                }
            }
        });

        for(int i = 0; i < list.size(); i++) {
            bw.write(list.get(i).getKey() + "\n");
        }
        br.close();
        bw.close();
    }
}
