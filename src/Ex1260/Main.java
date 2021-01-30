package Ex1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int max = 10001;
    static int node, edge, root, infoLeft, infoRight;
    static boolean[] check;
    static ArrayList<Integer> v[] = new ArrayList[max];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= node; i++){
            v[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            infoLeft = Integer.parseInt(st.nextToken());
            infoRight = Integer.parseInt(st.nextToken());
            v[infoLeft].add(infoRight);
            v[infoRight].add(infoLeft);
        }
        for(int i = 1; i <= node; i++){
            Collections.sort(v[i]);
        }

        check = new boolean[node+1];
        dfs(root);
        System.out.println();

        check = new boolean[node+1];
        bfs();
    }
    public static void dfs(int x){
        if(check[x])
            return;
        System.out.print(x+" ");
        check[x] = true;
        for(int i = 0; i < v[x].size(); i++){
            if(!check[v[x].get(i)])
                dfs(v[x].get(i));
        }
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        check[root] = true;
        System.out.print(root + " ");

        while(!q.isEmpty()){
            int next = q.poll();
            for(int i = 0; i < v[next].size(); i++){
                if(!check[v[next].get(i)]) {
                    check[v[next].get(i)] = true;
                    q.add(v[next].get(i));
                    System.out.print(v[next].get(i) + " ");
                }
            }
        }
    }
}