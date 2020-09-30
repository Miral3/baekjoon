package Ex11866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> que = new LinkedList<>();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int idx = 0;
        int[]arr = new int[N];

        for(int i = 1; i <= N; i++) {
            que.add(i);
        }

        while(!que.isEmpty()) {
            for(int i = 0; i < K-1; i++) {
                int rm = que.remove();
                que.add(rm);
            }
            arr[idx++] = que.remove();
        }

        System.out.print("<");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i < arr.length-1) {
                System.out.print(", ");
            }
        }
        System.out.println(">");
    }
}
