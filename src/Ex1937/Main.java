package Ex1937;

import java.io.*;

public class Main {
    public static int max = 1, n, arr[][], dp[][], dx[]={0, 0, -1, 1}, dy[]={1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int i, j; n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        String line[];

        for(i = 0; i < n; i++){
            line = br.readLine().split(" ");
            for(j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
                if(dp[i][j] == 0) {
                    dp[i][j] = 1;
                    mov(i, j);
                }
            }
        }
        bw.write(String.valueOf(max));
        bw.close();
        br.close();
    }
    private static void mov(int x, int y){
        int ax, ay, i;
        for(i = 0; i < 4; i++){
            ax = x + dx[i];
            ay = y + dy[i];

            if(isInRange(ax, ay) && shouldMov(x, y, ax, ay)){
                dp[ax][ay] = dp[x][y] + 1;
                if(max < dp[ax][ay])
                    max = dp[ax][ay];
                mov(ax,ay);
            }
        }
    }

    private static boolean shouldMov(int x, int y, int ax, int ay){
        return (arr[x][y] < arr[ax][ay] && dp[ax][ay] < dp[x][y] + 1);
    }

    private static boolean isInRange(int x, int y){
        return (0 <= x && x < n) && (0 <= y && y < n);
    }
}
