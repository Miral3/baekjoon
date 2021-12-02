package ex1374;

/*
문제 이름: 강의실
알고리즘: 그리디, 우선순위 큐, 정렬
자료구조: 우선순위 큐
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int start;
    int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node o) {
        return end - o.end;
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
            int start = Integer.parseInt(input[1]);
            int end = Integer.parseInt(input[2]);

            list.add(new Node(start, end));
        }

        Collections.sort(list, (o1, o2) -> o1.start - o2.start);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int max = 0;
        for(int i = 0; i < n; i++) {
            int start = list.get(i).start;
            int end = list.get(i).end;

            if(!pq.isEmpty()) {
                Node cur = pq.peek();
                int curS = cur.start;
                int curE = cur.end;

                if(curE <= start) {
                    pq.poll();
                }
            }
            pq.add(new Node(start, end));
            max = Math.max(pq.size(), max);
        }

        bw.write(max + "\n");
        br.close();
        bw.close();
    }
}
