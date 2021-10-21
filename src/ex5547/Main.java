package ex5547;

/*
문제 이름: 일루미네이션
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
    static int w;
    static int h;
    static int result = 0;
    static int[][] map;
    static boolean[][] isOutside;
    static boolean[][] isVisited;
    static int dy[] = {-1, -1, 0, 0, 1, 1};
    static int dx1[] = {1, 0, -1, 1, 1, 0};
    static int dx2[] = {-1, 0, -1, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        w = Integer.parseInt(input[0]);
        h = Integer.parseInt(input[1]);
        map = new int[h + 2][w + 2];
        isOutside = new boolean[h + 2][w + 2];
        isVisited = new boolean[h + 2][w + 2];

        for(int i = 1; i <= h; i++) {
            input = br.readLine().split(" ");
            for(int j = 1; j <= w; j++) {
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        bfs();

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        isOutside[0][0] = true;
        isVisited[0][0] = true;

        while(!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            for(int i = 0; i < 6; i++) {
                int ny = y + dy[i];
                int nx = 0;
                if(y % 2 == 1) {
                    nx = x + dx1[i];
                } else {
                    nx = x + dx2[i];
                }

                if(ny < 0 || nx < 0 || ny > h + 1 || nx > w + 1) {
                    continue;
                }
                if(isVisited[ny][nx] || map[ny][nx] == 1) {
                    continue;
                }

                isVisited[ny][nx] = true;
                isOutside[ny][nx] = true;
                que.add(new Node(ny, nx));
            }
        }


        for(int i = 1; i <= h; i++) {
            for(int j = 1; j <= w; j++) {
                if(!isVisited[i][j] && map[i][j] == 1) {
                    que = new LinkedList<>();
                    que.add(new Node(i, j));
                    isVisited[i][j] = true;

                    while(!que.isEmpty()) {
                        Node cur = que.poll();
                        int y = cur.y;
                        int x = cur.x;

                        for(int k = 0; k < 6; k++) {
                            int ny = y + dy[k];
                            int nx = 0;
                            if(y % 2 == 1) {
                                nx = x + dx1[k];
                            } else {
                                nx = x + dx2[k];
                            }

                            if(ny < 0 || nx < 0 || ny > h + 1 || nx > w + 1) {
                                continue;
                            }
                            if(isOutside[ny][nx]) {
                                result++;
                                continue;
                            }
                            if(isVisited[ny][nx] || map[i][j] == 0) {
                                continue;
                            }

                            isVisited[ny][nx] = true;
                            que.add(new Node(ny, nx));
                        }
                    }
                }
            }
        }
    }
}
