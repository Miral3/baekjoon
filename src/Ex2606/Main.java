package Ex2606;

import java.io.*;
import java.util.*;

public class Main {
    static final int max = 10001;
    static int node, edge, root = 1, infoLeft, infoRight, cnt=0;
    static boolean[] check;
    static ArrayList<Integer> v[] = new ArrayList[max];

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
        for(int i = 1; i <= node; i++){
            Collections.sort(v[i]);
        }

        check = new boolean[node+1];
        bfs();
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        check[root] = true;

        while(!q.isEmpty()){
            int next = q.poll();
            for(int i = 0; i < v[next].size(); i++){
                if(!check[v[next].get(i)]) {
                    check[v[next].get(i)] = true;
                    q.add(v[next].get(i));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}