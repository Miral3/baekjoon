package ex14395;

/*
문제 이름: 4연산
알고리즘: BFS
자료구조: 큐
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int num;
    int cnt;
    String calculate;

    public Node(int num, int cnt, String calculate) {
        this.num = num;
        this.cnt = cnt;
        this.calculate = calculate;
    }
}

public class Main {
    static final int MAX = 1000000001;
    static int s;
    static int t;
    static String answer = "";
    static boolean[] isVisited = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        s = Integer.parseInt(input[0]);
        t = Integer.parseInt(input[1]);

        int result = BFS();
        if(result == 1) {
            bw.write(answer + "\n");
        } else {
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }

    public static int BFS() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(s, 0, ""));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int num = cur.num;
            int cnt = cur.cnt;
            String cal = cur.calculate;

            if(num == t) {
                if(cal.equals("")) {
                    return 0;
                } else {
                    answer = cal;
                    return 1;
                }
            }
            if (num < 31623 && !isVisited[num * num]) {
                isVisited[num * num] = true;
                que.add(new Node(num * num, cnt + 1, cal + "*"));
            }

            if (num < 500000001 && !isVisited[num + num]) {
                isVisited[num + num] = true;
                que.add(new Node(num + num, cnt + 1, cal + "+"));
            }

            if (!isVisited[num - num]) {
                isVisited[num - num] = true;
                que.add(new Node(num - num, cnt + 1, cal + "-"));
            }

            if (num > 0 && !isVisited[num / num]) {
                isVisited[num / num] = true;
                que.add(new Node(num / num, cnt + 1, cal + "/"));
            }
        }
        return -1;
    }
}
