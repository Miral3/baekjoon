package Ex1021;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int dequeSize = Integer.parseInt(input[0]);
        int targetSize = Integer.parseInt(input[1]);
        int cnt = 0;
        String[] target = br.readLine().split(" ");
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i <= dequeSize; i++) {
            deque.add(i);
        }

        for(int i = 0; i < targetSize; i++) {
            int leftCnt = 0;
            int rightCnt = 0;
            if(Integer.parseInt(target[i]) == deque.peekFirst()) {
                deque.removeFirst();
                continue;
            }
            else {
                Deque<Integer> leftCopy = new ArrayDeque<>(deque);
                Deque<Integer> rightCopy = new ArrayDeque<>(deque);
                /* turn left */
                while(true) {
                    if(leftCopy.peekFirst() == Integer.parseInt(target[i])){
                        leftCopy.removeFirst();
                        break;
                    }
                    int rm = leftCopy.removeFirst();
                    leftCopy.addLast(rm);
                    leftCnt++;
                }
                /* turn right */
                while(true) {
                    if(rightCopy.peekFirst() == Integer.parseInt(target[i])){
                        rightCopy.removeFirst();
                        break;
                    }
                    int rm = rightCopy.removeLast();
                    rightCopy.addFirst(rm);
                    rightCnt++;
                }
                if(leftCnt > rightCnt) {
                    cnt += rightCnt;
                    deque = new ArrayDeque<>(rightCopy);
                }
                else {
                    cnt += leftCnt;
                    deque = new ArrayDeque<>(leftCopy);
                }
            }
        }
        System.out.println(cnt);
    }
}
