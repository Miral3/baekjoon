package ex1715;

/*
문제 이름: 카드 정렬하기
알고리즘: 그리디, 우선순위 큐
자료구조: 우선순위 큐
*/

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pque = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pque.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        if(pque.size() == 1) {
            System.out.println(0);
            return;

        }
        while(true) {
            int first = pque.poll();
            int second = pque.poll();
            int sum = first + second;

            if(pque.isEmpty()) {
                result += sum;
                break;
            }
            pque.add(sum);
            result += sum;
        }

        bw.write(result + "\n");

        br.close();
        bw.close();
    }
}
