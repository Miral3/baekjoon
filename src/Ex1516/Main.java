package Ex1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static int testCase;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int building;
        int[] degree;
        String[] input;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase+1; i++) {
            graph.add(new ArrayList<>());
        }

        degree = new int[testCase+1];
        time = new int[testCase+1];
        for(int i = 1; i < testCase+1; i++) {
            input = br.readLine().split(" ");
            time[i] = Integer.parseInt(input[0]);
            if(!input[1].equals("-1")) {
                building = Integer.parseInt(input[1]);
                graph.get(building).add(i);
                degree[i]++;
            }
            if(input.length > 3) {
                for(int j = 2; j < input.length - 1; j++) {
                    building = Integer.parseInt(input[j]);
                    graph.get(building).add(i);
                    degree[i]++;
                }
            }
        }
        topologySort(graph, degree);

        br.close();
    }

    public static void topologySort(ArrayList<ArrayList<Integer>> graph, int[] degree) {
        LinkedList<Integer> que = new LinkedList<>();
        int[] result = new int[testCase+1];

        for(int i = 1; i < testCase+1; i++) {
            result[i] = time[i];
            if(degree[i] == 0) {
                que.add(i);
            }
        }

        for(int i = 1; i < testCase+1; i++) {
            int rm = que.remove();
            for(int nxtRm : graph.get(rm)) {
                result[nxtRm] = Math.max(result[nxtRm], result[rm] + time[nxtRm]);
                degree[nxtRm]--;
                if(degree[nxtRm] == 0) {
                    que.add(nxtRm);
                }
            }
        }

        for(int i = 1; i < testCase+1; i++){
            System.out.println(result[i]);
        }
    }
}
