package Ex10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[][] stair = new int[input][12];
        int count = 0;

        for(int i = 2; i < 11; i++){
            stair[0][i] = 1;
        }

        for(int i = 1; i < input; i++) {
            for(int j = 1; j < 11; j++) {
                stair[i][j] = (stair[i-1][j-1] + stair[i-1][j+1]) % 1000000000;
            }
        }

        for(int i = 1; i < 11; i++){
            count = (count + stair[input-1][i]) % 1000000000;
        }

        System.out.print(count);
    }
}
