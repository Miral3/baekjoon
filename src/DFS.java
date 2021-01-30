import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DFS {
    static int N;
    static int M;
    static int root;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputA;
        int inputB;
        String[] input;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        root = Integer.parseInt(input[2]);

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

        check = new boolean[N+1];
        DFS(graph, root);
    }

    public static void DFS(ArrayList<ArrayList<Integer>> graph, int node) {
        if(check[node]) {
            return;
        }
        System.out.print(node + " ");
        check[node] = true;
        for(int nxt : graph.get(node)){
            if(!check[nxt]) {
                DFS(graph, nxt);
            }
        }
    }
}
