package ex9519;

/*
문제 이름: 졸려
알고리즘: 구현, 문자열
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        String str = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        list.add(str);
        int idx = 1;
        int size = str.length() / 2;

        while (true) {
            String prev = list.get(idx - 1);
            StringBuilder next = new StringBuilder();
            char[] pArr = prev.toCharArray();
            char[] nArr = new char[prev.length()];

            for (int i = 0; i < size; i++) {
                int left = i;
                int target = prev.length() - 1 - i;
                int right = i + 1;

                nArr[i * 2] = pArr[left];
                nArr[i * 2 + 1] = pArr[target];
                if (prev.length() % 2 == 0 && i == size - 1) {
                    continue;
                }
                nArr[i * 2 + 2] = pArr[right];
            }

            for (int i = 0; i < prev.length(); i++) {
                next.append(nArr[i]);
            }

            if (list.contains(next.toString())) {
                if (idx == 1) {
                    bw.write(list.get(0) + "\n");
                } else {
                    bw.write(list.get(idx - (x % idx)) + "\n");
                }
                break;
            }
            list.add(next.toString());
            idx++;
        }

        br.close();
        bw.close();
    }
}
