package ex5639;

/*
문제 이름: 이진 검색 트리
알고리즘: 트리, 재귀
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int[] tree = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 0;
        String input;
        while(true) {
            input = br.readLine();
            if(input == null || input.equals("")) {
                break;
            }
            tree[idx++] = Integer.parseInt(input);
        }

        preOrder(0, idx - 1);

        br.close();
        bw.close();
    }

    public static void preOrder(int start, int end) {
        if(start > end) {
            return;
        }

        int root = start + 1;
        while(root <= end && tree[root] < tree[start]) {
            root++;
        }
        preOrder(start + 1, root - 1);
        preOrder(root, end);
        System.out.println(tree[start]);
    }
}
