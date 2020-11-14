package Ex2606;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputA;
        int inputB;
        String[] input;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            inputA = Integer.parseInt(input[0]);
            inputB = Integer.parseInt(input[1]);
            graph.get(inputA).add(inputB);
            graph.get(inputB).add(inputA);
        }

        BFS(graph);

        br.close();
    }

    public static void BFS(ArrayList<ArrayList<Integer>> graph) {
        LinkedList<Integer> que = new LinkedList<>();
        boolean[] check = new boolean[N+1];
        int cnt = 0;

        que.add(1);
        check[1] = true;

        while(!que.isEmpty()) {
            int rm = que.remove();
            for(int nxtRm : graph.get(rm)) {
                if(!check[nxtRm]) {
                    check[nxtRm] = true;
                    que.add(nxtRm);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}