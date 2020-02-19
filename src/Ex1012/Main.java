package Ex1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int count;
    static char[][] map;
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase, width, length, cabbage, coordinateX, coordinateY;
        testCase = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());
            cabbage = Integer.parseInt(st.nextToken());

            map = new char[length][width];
            isVisited = new boolean[length][width];
            for(int j = 0; j < cabbage; j++){
                st = new StringTokenizer(br.readLine());
                coordinateX = Integer.parseInt(st.nextToken());
                coordinateY = Integer.parseInt(st.nextToken());
                map[coordinateY][coordinateX] = '1';
            }
            for(int k = 0; k < length; k ++){
                for(int f = 0; f < width; f++){
                    if((!isVisited[k][f]) && map[k][f] == '1') {
                        isVisited[k][f] = true;
                        count = 1;
                        dfs(k, f, width, length);
                        q.add(count);
                    }
                }
            }
            System.out.println(q.size());
            q.clear();
        }
    }
    public static void dfs(int x, int y, int width, int length){
        if(!(x-1 < 0) && map[x-1][y] == '1' && (!isVisited[x-1][y])){
            count++;
            isVisited[x-1][y] = true;
            dfs(x-1, y, width, length);
        }
        if(!(x+1 >= length) && map[x+1][y] == '1' && (!isVisited[x+1][y])){
            count++;
            isVisited[x+1][y] = true;
            dfs(x+1, y, width, length);
        }
        if(!(y-1 < 0) && map[x][y-1] == '1' && (!isVisited[x][y-1])){
            count++;
            isVisited[x][y-1] = true;
            dfs(x, y-1, width, length);
        }
        if(!(y+1 >= width) && map[x][y+1] == '1' && (!isVisited[x][y+1])){
            count++;
            isVisited[x][y+1] = true;
            dfs(x, y+1, width, length);
        }

    }
}
