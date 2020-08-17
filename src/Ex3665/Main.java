package Ex3665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static int N; // 팀의 수 n
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase;
        int M; // 상대적인 등수가 바뀐 쌍의 수
        int teamA, teamB; // 상대적인 등수가 바뀐 각 팀
        int[] degree; // 각 팀의 차수
        int[] sort;
        String[] input;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


        testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            N = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            sort = new int[N+1];
            degree = new int[N+1];

            for(int j = 1; j < N+1; j++){
                sort[j] = Integer.parseInt(input[j-1]);
            }

            M = Integer.parseInt(br.readLine());

            if(M == 0) {
                for(int a = 1; a < N+1; a++) {
                    System.out.print(sort[a] + " ");
                }
                break;
            }
            else {
                for (int k = 0; k < N + 1; k++) {
                    graph.add(new ArrayList<>());
                }
                for (int l = 0; l < M; l++) {
                    input = br.readLine().split(" ");
                    teamA = Integer.parseInt(input[0]);
                    teamB = Integer.parseInt(input[1]);
                    graph.get(teamA).add(teamB);
                    degree[teamB]++;
                }
            }
            topologySort(graph, degree, sort);
        }
    }

    public static void topologySort(ArrayList<ArrayList<Integer>> graph, int[] degree, int[] sort) {
        LinkedList<Integer> que = new LinkedList<>();

        for(int i = 1; i < N+1; i++) {
            if(degree[sort[i]] == 0) {
                que.add(i);
            }
        }

        for(int i = 0; i < N; i++) {
            if(que.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                break;
            }
            int del = que.remove();
            System.out.print(sort[del] + " ");
            for(int nextDel : graph.get(sort[del])) {
                degree[nextDel]--;
                if(degree[nextDel] == 0) {
                    que.add(sort[nextDel]);
                }
            }
        }
        System.out.println();
    }
}
