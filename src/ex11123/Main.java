package ex11123;

/*
문제 이름: 양 한마리... 양 두마리...
알고리즘: bfs
자료구조: 배열, 큐
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int h;
    static int w;
    static char[][] graph;
    static boolean[][] isVisited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            String[] input = br.readLine().split(" ");
            h = Integer.parseInt(input[0]);
            w = Integer.parseInt(input[1]);
            graph = new char[h][w];
            isVisited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                char[] input2 = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    graph[i][j] = input2[j];
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!isVisited[i][j] && graph[i][j] == '#') {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            bw.write(count + "\n");
        }

        br.close();
        bw.close();
    }

    public static void bfs(int startY, int startX) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(startY, startX));
        isVisited[startY][startX] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= h || nx >= w) {
                    continue;
                }

                if (isVisited[ny][nx] || graph[ny][nx] == '.') {
                    continue;
                }

                que.add(new Node(ny, nx));
                isVisited[ny][nx] = true;
            }
        }
    }
}
