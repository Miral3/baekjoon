package ex15970;

/*
문제 이름: 화살표 그리기
알고리즘: 브루트포스, 정렬
자료구조: 연결 리스트
*/

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

class Node implements Comparable<Node> {
    int position;
    int color;

    public Node(int position, int color) {
        this.position = position;
        this.color = color;
    }

    @Override
    public int compareTo(Node o) {
        if (color - o.color > 0) {
            return 1;
        } else if (color - o.color < 0) {
            return -1;
        } else {
            return position - o.position;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Node> list = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int position = Integer.parseInt(input[0]);
            int color = Integer.parseInt(input[1]);

            list.add(new Node(position, color));
        }

        Collections.sort(list);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int position = list.get(i).position;
            int color = list.get(i).color;
            int min = Integer.MAX_VALUE;

            if (i - 1 >= 0 && list.get(i - 1).color == color) {
                min = Math.min(min, position - list.get(i - 1).position);
            }
            if (i + 1 < n && list.get(i + 1).color == color) {
                min = Math.min(min, list.get(i + 1).position - position);
            }

            answer += min;
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
