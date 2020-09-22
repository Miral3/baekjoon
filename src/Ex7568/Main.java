package Ex7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[][] bulk = new int[testCase][3];

        for(int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            bulk[i][0] = Integer.parseInt(input[0]);
            bulk[i][1] = Integer.parseInt(input[1]);
            bulk[i][2] = 1;
        }

        for(int i = 0; i < testCase; i++) {
            for(int j = 0; j < testCase; j++) {
                if(bulk[i][0] < bulk[j][0] && bulk[i][1] < bulk[j][1]) {
                    bulk[i][2]++;
                }
            }
        }
        for(int i = 0; i < testCase; i++) {
            System.out.print(bulk[i][2] + " ");
        }
    }
}
