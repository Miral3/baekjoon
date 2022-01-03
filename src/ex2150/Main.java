package ex2150;

/*
문제 이름: Strongly Connected Component
알고리즘: 강한 연결 요소(SCC)
자료구조: 배열 리스트, 스택
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.TreeMap;

public class Main {
    static int v;
    static int e;
    static boolean[] isVisited;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer>[] reverse;
    static ArrayList<Integer>[] result;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        v = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);

        isVisited = new boolean[v + 1];
        list = new ArrayList[v + 1];
        reverse = new ArrayList[v + 1];
        result = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
            result[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            list[a].add(b);
            reverse[b].add(a);
        }

        for (int i = 1; i <= v; i++) {
            if(!isVisited[i]) {
                DFS(i);
            }
        }

        isVisited = new boolean[v + 1];
        int idx = 0;
        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if(isVisited[cur]) {
                continue;
            }

            reverseDFS(cur, idx);
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(idx + "\n");

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < idx; i++) {
            Collections.sort(result[i]);
            map.put(result[i].get(0), i);
        }

        map.keySet().forEach(key -> {
            int val = map.get(key);

            for (int now : result[val]) {
                sb.append(now + " ");
            }
            sb.append("-1\n");
        });

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static void DFS(int x) {
        isVisited[x] = true;
        for (Integer val : list[x]) {
            if(!isVisited[val]) {
                DFS(val);
            }
        }
        stack.add(x);
    }

    public static void reverseDFS(int x, int idx) {
        isVisited[x] = true;
        result[idx].add(x);
        for (Integer val : reverse[x]) {
            if(!isVisited[val]) {
                reverseDFS(val, idx);
            }
        }
    }
}
