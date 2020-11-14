package Ex1236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        char[][] castle = new char[x][y];
        boolean[] ckX = new boolean[x];
        boolean[] ckY = new boolean[y];
        boolean[][] ck = new boolean[x][y];
        int cnt = 0;

        for(int i = 0; i < x; i ++) {
            String state = br.readLine();
            for (int j = 0; j < y; j++) {
                castle[i][j] = state.charAt(j);
                if(state.charAt(j) == 'X') {
                   ckX[i] = true;
                   ckY[j] = true;
                }
            }
        }

        System.out.println(cnt);
    }
}
