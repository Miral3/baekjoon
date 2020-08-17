package Ex2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stuNum1, stuNum2;
        int[] degree;
        String[] input;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        degree = new int[N+1];

        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            stuNum1 = Integer.parseInt(input[0]);
            stuNum2 = Integer.parseInt(input[1]);
            graph.get(stuNum1).add(stuNum2);
            degree[stuNum2]++;
        }

        topoligicSorting(graph, degree);

    }

    public static void topoligicSorting(ArrayList<ArrayList<Integer>> graph, int[] degree) {
        LinkedList<Integer> que = new LinkedList<>();

        for(int i = 1; i < N+1; i++) {
            if(degree[i] == 0) {
                que.add(i);
            }
        }

        for(int i = 0; i < N; i++) {
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