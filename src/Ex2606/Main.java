package Ex2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int max = 101;
    static int node, edge, infoLeft, infoRight;
    static boolean[] check;
    static ArrayList<Integer> v[] = new ArrayList[max];
    static Queue<Integer> bfsRoot = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());


        for(int i = 1; i <= node; i++){
            v[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            infoLeft = Integer.parseInt(st.nextToken());
            infoRight = Integer.parseInt(st.nextToken());
            v[infoLeft].add(infoRight);
            v[infoRight].add(infoLeft);
        }

//        check = new boolean[node+1];
//        dfs(1);
//        System.out.println();

        check = new boolean[node+1];
        bfs();
        System.out.print(bfsRoot.size()-1);
    }
//    public static void dfs(int x){
//        if(check[x])
//            return;
//        System.out.print(x+" ");
//        check[x] = true;
//        for(int i = 0; i < v[x].size(); i++){
//            if(!check[v[x].get(i)])
//                dfs(v[x].get(i));
//        }
//    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        check[1] = true;

        while(!q.isEmpty()){
            int next = q.poll();
            bfsRoot.add(next);
            for(int i = 0; i < v[next].size(); i++){
                if(!check[v[next].get(i)]) {
                    check[v[next].get(i)] = true;
                    q.add(v[next].get(i));
                }
            }
        }
    }
}