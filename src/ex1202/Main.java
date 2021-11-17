package ex1202;

/*
문제 이름: 보석 도둑
알고리즘: 정렬, 우선순위 큐, 그리디
자료구조: 우선순위 큐, 배열 리스트, 배열
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int weight;
    int value;

    public Node(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        List<Node> list = new ArrayList<>();
        int[] bag = new int[k];

        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");

            int weight = Integer.parseInt(input[0]);
            int value = Integer.parseInt(input[1]);

            list.add(new Node(weight, value));
        }

        for(int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Collections.sort(list);
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        int j = 0;
        for(int i = 0; i < k; i++) {
            while(j < n && list.get(j).weight <= bag[i]) {
                pq.add(list.get(j++).value);
            }

            if(!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
