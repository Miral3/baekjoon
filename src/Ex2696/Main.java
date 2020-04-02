package Ex2696;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            int size = Integer.parseInt(br.readLine());
            int arr[] = new int[size+1];

            for(int j = 0, k=1; j <= size/10; j++){
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()){
                    arr[k++] = Integer.parseInt(st.nextToken());
                }
            }
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            System.out.println((size/2)+1);
            for(int l = 1; l < arr.length; l++) {
                if(minHeap.size() == maxHeap.size()){
                    maxHeap.add(arr[l]);
                    if(!minHeap.isEmpty() && arr[l] > minHeap.peek()){
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(minHeap.poll());
                    }
                }
                else if(minHeap.size() != maxHeap.size()){
                    minHeap.add(arr[l]);
                    if(!maxHeap.isEmpty() && arr[l] < maxHeap.peek()){
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(minHeap.poll());
                    }
                }
                if(l % 2 == 1){
                    System.out.print(maxHeap.peek() + " ");
                }
            }
            System.out.println();
        }
    }
}