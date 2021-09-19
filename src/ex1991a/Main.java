package ex1991a;

/*
문제 이름: 트리 순회
알고리즘: 트리, 재귀
자료구조: 해시맵, 배열리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static StringBuilder result = new StringBuilder();
    static Map<String, List<String>> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            List<String> list = new ArrayList<>();

            list.add(input[1]);
            list.add(input[2]);
            tree.put(input[0], list);
        }

        preOrder("A");
        result.append("\n");
        inOrder("A");
        result.append("\n");
        postOrder("A");
        result.append("\n");
        bw.write(result.toString() + "\n");

        br.close();
        bw.close();
    }

    static void preOrder(String s) {
        if(s.equals(".")) {
            return;
        }

        result.append(s);
        preOrder(tree.get(s).get(0));
        preOrder(tree.get(s).get(1));
    }

    static void inOrder(String s) {
        if(s.equals(".")) {
            return;
        }

        inOrder(tree.get(s).get(0));
        result.append(s);
        inOrder(tree.get(s).get(1));
    }

    static void postOrder(String s) {
        if(s.equals(".")) {
            return;
        }

        postOrder(tree.get(s).get(0));
        postOrder(tree.get(s).get(1));
        result.append(s);
    }
}
