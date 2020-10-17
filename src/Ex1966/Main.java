package Ex1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            int sel = Integer.parseInt(input[1]);
            int[] priority = new int[num];
            Queue<Point> que = new LinkedList<>();

            input = br.readLine().split(" ");
            Point p;
            for(int j = 0; j < num; j++) {
                priority[j] = Integer.parseInt(input[j]);
                p = new Point(j, priority[j]);
                que.add(p);
            }

            Arrays.sort(priority);
            int cnt = 0;
            int idx = priority.length-1;
            while(true) {
                p = que.poll();
                int x = p.x;
                int y = p.y;
                if(y != priority[idx]) {
                    que.add(p);
                }
                else{
                    cnt++;
                    idx--;
                    if(x == sel) {
                        break;
                    }
                }

            }
            System.out.println(cnt);
        }
    }
}
class Point{
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}