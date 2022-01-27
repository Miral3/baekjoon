package Ex1655;

/*
문제 이름: 가운데를 말해요
알고리즘: 우선순위 큐
자료구조: 우선순위 큐
*/

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int input = Integer.parseInt(br.readLine());
            if(minHeap.size() == maxHeap.size()){
                maxHeap.add(input);
                if(!minHeap.isEmpty() && input > minHeap.peek()){
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            }
            else if(minHeap.size() != maxHeap.size()){
                minHeap.add(input);
                if(!maxHeap.isEmpty() && input < maxHeap.peek()){
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            }
            bw.write(maxHeap.peek() + "\n");
        }

        br.close();
        bw.close();
    }
}
