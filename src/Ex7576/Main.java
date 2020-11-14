package Ex7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int row;
        int column;
        int[][] box;
        String[] input;

        input = br.readLine().split(" ");
        row = Integer.parseInt(input[0]);
        column = Integer.parseInt(input[1]);

        box = new int[column][row];
        check = new boolean[column][row];
        for(int i = 0; i < column; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < row; j++) {
                box[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < column; i++) {
            for(int j = 0; j < row; j++) {
                if(!check[i][j] && box[i][j] == 1) {

                }
            }
        }
    }
}
