package Ex1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            System.out.println(maxHeap.peek());
        }
    }
}
