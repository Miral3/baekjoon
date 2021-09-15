package ex2012;

/*
문제 이름: 등수 매기기
알고리즘: 그리디, 정렬
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node>{
    int idx, expect;
    public Node(int idx, int expect) {
        this.idx = idx;
        this.expect = expect;
    }

    public int compareTo(Node o) {
        return expect - o.expect;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int expect = Integer.parseInt(br.readLine());
            list.add(new Node(i, expect));
        }
        Collections.sort(list);
        long answer = 0;
        for(int i = 1; i <= n; i++) {
            answer += Math.abs(i - list.get(i-1).expect);
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
