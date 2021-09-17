package ex11000;

/*
문제 이름: 강의실 배정
알고리즘: 그리디, 정렬, 우선순위 큐
자료구조: 우선순위 큐, 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int start, end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Node o) {
        return start - o.start;
    }
}

class Class implements Comparable<Class> {
    int start, end;

    public Class(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Class c) {
        return end - c.end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            list.add(new Node(start, end));
        }

        Collections.sort(list);

        PriorityQueue<Class> que = new PriorityQueue<>();
        que.add(new Class(list.get(0).start, list.get(0).end));
        int max = 1;
        for(int i = 1; i < list.size(); i++) {
            int start = list.get(i).start;
            int end = list.get(i).end;
            while(true) {
                if (!que.isEmpty() && start >= que.peek().end) {
                    que.poll();
                } else {
                    que.add(new Class(start, end));
                    break;
                }
            }

            max = Math.max(max, que.size());
        }

        bw.write(max + "\n");

        br.close();
        bw.close();
    }
}
