package ex9019;

/*
문제 이름: DSLR
알고리즘: 그래프 탐색(bfs)
자료구조: 큐
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int num;
    String command;

    public Node(int num, String command) {
        this.num = num;
        this.command = command;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            System.out.println(bfs(A, B));
        }

        br.close();
        bw.close();
    }

    public static String bfs(int A, int B) {
        Queue<Node> que = new LinkedList<>();
        boolean[] isVisited = new boolean[10000];

        que.add(new Node(A, ""));
        isVisited[A] = true;

        String result = "";
        while(!que.isEmpty()) {
            Node cur = que.poll();
            int num = cur.num;
            String command = cur.command;

            if(num == B) {
                result = command;
                break;
            }

            int temp = (num * 2) % 10000;
            if(!isVisited[temp]) {
                isVisited[temp] = true;
                que.add(new Node(temp, command + "D"));
            }

            temp = (num-1) < 0 ? 9999 : num-1;
            if(!isVisited[temp]) {
                isVisited[temp] = true;
                que.add(new Node(temp, command + "S"));
            }

            temp = (num % 1000) * 10 + (num / 1000);
            if(!isVisited[temp]) {
                isVisited[temp] = true;
                que.add(new Node(temp, command + "L"));
            }


            temp = (num % 10) * 1000 + (num / 10);
            if(!isVisited[temp]) {
                isVisited[temp] = true;
                que.add(new Node(temp, command + "R"));
            }
        }
        return result;
    }
}
