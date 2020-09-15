package Ex4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int column = 0;
        int row = 0;
        int diagonal = 0;
        int [] input = new int[3];

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 3; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(input);
            column = input[0];
            row = input[1];
            diagonal = input[2];

            if(input[0] == 0) {
                break;
            }

            column = (int)Math.pow(column, 2);
            row = (int)Math.pow(row, 2);
            diagonal = (int)Math.pow(diagonal, 2);

            if(diagonal == (column+row)) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }
        }
    }
}
