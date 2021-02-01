package Ex11724;

import java.io.*;
import java.util.*;

public class Main {
    static int node, edge, root, infoLeft, infoRight, cnt = 0;
    static final int max = 10001;
    static boolean[] visited;
    static ArrayList<Integer> v[] = new ArrayList[max];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i <= node; i++) {
            v[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            infoLeft = Integer.parseInt(st.nextToken());
            if(i == 0) {
                root = infoLeft;
            }
            infoRight = Integer.parseInt(st.nextToken());
            v[infoLeft].add(infoRight);
            v[infoRight].add(infoLeft);
        }
        
        for(int i = 1; i <= node; i++) {
            Collections.sort(v[i]);
        }
        
        visited = new boolean[node + 1];
        for(int i = 0; i < node; i++) {
            if(!visited[i+1]) {
                BFS(i+1);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void BFS(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;

        while(!q.isEmpty()){
            int next = q.poll();
            for(int i = 0; i < v[next].size(); i++){
                if(!visited[v[next].get(i)]) {
                    visited[v[next].get(i)] = true;
                    q.add(v[next].get(i));
                }
            }
        }
    }
}
