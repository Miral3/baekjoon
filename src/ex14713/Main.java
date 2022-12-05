package ex14713;

/*
문제 이름: 앵무새
알고리즘: 구현, 큐
자료구조: 배열 리스트, 큐
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Queue<String>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            Queue<String> que = new LinkedList<>();
            for (String str : input) {
                que.add(str);
            }
            list.add(que);
        }

        String[] input = br.readLine().split(" ");
        boolean isPossible = true;
        for (String str : input) {
            boolean isContain = false;
            for (int i = 0; i < n; i++) {
                if (!list.get(i).isEmpty() && list.get(i).peek().equals(str)) {
                    isContain = true;
                    list.get(i).poll();
                    break;
                }
            }
            if (!isContain) {
                isPossible = false;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (list.get(i).size() != 0) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            bw.write("Possible\n");
        } else {
            bw.write("Impossible\n");
        }
        br.close();
        bw.close();
    }
}
