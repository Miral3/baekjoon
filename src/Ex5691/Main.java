package Ex5691;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static int min(int a, int b, int c){
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        minQueue.add(a);
        minQueue.add(b);
        minQueue.add(c);
        return minQueue.poll();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int A, B, C;

        while(true){
            String[] input = br.readLine().split(" ");
            A = Integer.parseInt(input[0]);
            B = Integer.parseInt(input[1]);
            if(A == 0 && B == 0)
                break;
            if(A > B){
                int temp = A;
                A = B;
                B = temp;
            }
            C = min((2*A)-B, (A+B)/2, (2*B)-A);
            sb.append(C).append("\n");
//            System.out.println(C);
        }
        System.out.println(sb);
    }
}
