package Ex2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int num;
    static int testCase;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numStr = br.readLine().split(" ");
        num = Integer.parseInt(numStr[0]); // 비교할 학생의 수
        testCase = Integer.parseInt(numStr[1]); // 비교할 횟수
        int[] degree = new int[num + 1]; // 각 원소의 차수를 저장할 변수

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //
        for(int i = 0; i < num + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < testCase; i++) {
            String[] arrStr = br.readLine().split(" ");
            int input1 = Integer.parseInt(arrStr[0]);
            int input2 = Integer.parseInt(arrStr[1]);
            graph.get(input1).add(input2);
            degree[input2]++;
        }

        topologySort(graph, degree);
    }

    public static void topologySort(ArrayList<ArrayList<Integer>> graph, int[] degree) {
        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i < num + 1; i++) {
            if(degree[i] == 0) {
                que.add(i);
            }
        }

        for(int i = 0; i < num; i++) {
            int del = que.remove();
            System.out.print(del + " ");

            for(int nextDel : graph.get(del)) {
                degree[nextDel]--;
                if(degree[nextDel] == 0) {
                    que.add(nextDel);
                }
            }
        }
    }
}
