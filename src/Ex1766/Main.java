package Ex1766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int[] degree;
        int inputA;
        int inputB;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        degree = new int[N+1];
        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            inputA = Integer.parseInt(input[0]);
            inputB = Integer.parseInt(input[1]);
            graph.get(inputA).add(inputB);
            degree[inputB]++;
        }

        topologySort(graph, degree);

        br.close();
    }

    public static void topologySort(ArrayList<ArrayList<Integer>> graph, int[] degree) {
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i = 1; i < N + 1; i++){
            if(degree[i] == 0) {
                que.add(i);
            }
        }

        for(int i = 0 ; i < N; i++) {
            int remove = que.remove();
            System.out.print(remove + " ");
            for(int nextRemove : graph.get(remove)) {
                degree[nextRemove]--;
                if(degree[nextRemove] == 0) {
                    que.add(nextRemove);
                }
            }
        }
    }
}
