import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
    static int N;
    static int M;
    static int root;
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

        BFS(graph);
    }

    public static void BFS(ArrayList<ArrayList<Integer>> graph) {
        LinkedList<Integer> que = new LinkedList<>();
        boolean[] check = new boolean[N+1];

        que.add(root);
        check[root] = true;

        for(int i = 0; i < N; i++) {
            int rm = que.remove();
            System.out.print(rm + " ");
            for(int nxtRm : graph.get(rm)) {
                if(!check[nxtRm]) {
                    check[nxtRm] = true;
                    que.add(nxtRm);
                }
            }
        }
    }
}
