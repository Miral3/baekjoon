package Ex1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static int N; // 건물의 개수
    static int win; // 승리하기 위해 건설해야 한 건물의 번호
    static int[] time; // 건설에 걸리는 시간
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase;
        int M; // 건선순서규칙 개수
        int inputA; // 건설순서
        int inputB; // 건설순서
        int[] degree; // 건물 간 차수
        String[] input;

        testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            time = new int[N+1];
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for(int j = 0; j < N+1; j++) {
                graph.add(new ArrayList<>());
            }

            input = br.readLine().split(" ");
            for(int k = 1; k < input.length+1; k++) {
                time[k] = Integer.parseInt(input[k-1]);
            }

            degree = new int[N+1];
            for(int l = 0; l < M; l++) {
                input = br.readLine().split(" ");
                inputA = Integer.parseInt(input[0]);
                inputB = Integer.parseInt(input[1]);
                graph.get(inputA).add(inputB);
                degree[inputB]++;
            }
            win = Integer.parseInt(br.readLine());

            topologySort(graph, degree);
        }
        br.close();
    }

    public static void topologySort(ArrayList<ArrayList<Integer>> graph, int[] degree) {
        LinkedList<Integer> que = new LinkedList<>();
        int[] result = new int[N+1];

        for(int i = 1; i < N+1; i++) {
            result[i] = time[i];
            if(degree[i] == 0) {
                que.add(i);
            }
        }

        while(!que.isEmpty()) {
            int rm = que.remove();
            for(int nxtRm : graph.get(rm)) {
                result[nxtRm] = Math.max(result[nxtRm], result[rm] + time[nxtRm]);
                degree[nxtRm]--;
                if(degree[nxtRm] == 0) {
                    que.add(nxtRm);
                }
            }
        }
        System.out.println(result[win]);
    }
}
