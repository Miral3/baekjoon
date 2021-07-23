package ex1015;

/*
문제 이름: 수열 정렬
알고리즘: 정렬
자료구조: 연결 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Node {
    int value, idx;

    public Node(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new Node(Integer.parseInt(input[i]), i));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.value < o2.value) {
                    return -1;
                } else if(o1.value > o2.value) {
                    return 1;
                } else {
                    if(o1.idx < o2.idx) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        int[] p = new int[n];
        for(int i = 0; i < n; i++) {
            p[list.get(i).idx] = i;
        }

        for(int i = 0; i < n; i++) {
            bw.write(p[i] + " ");
        }

        br.close();
        bw.close();
    }
}
