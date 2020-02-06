package Ex1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int triangle[][] = new int[testCase][testCase];

        for(int i = 0 ; i < testCase; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i+1; j++) {
                int input = Integer.parseInt(st.nextToken());
                triangle[i][j] = input;
            }
        }

        triangle[1][0] = triangle[1][0] + triangle[0][0];
        triangle[1][1] = triangle[1][1] + triangle[0][0];

        for(int i = 2; i < testCase; i++){
            triangle[i][0] = triangle[i][0] + triangle[i-1][0];
            triangle[i][i] = triangle[i][i] + triangle[i-1][i-1];
            for(int j = 1; j < i; j++){
                triangle[i][j] = triangle[i][j] + Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }

        int max = triangle[testCase-1][0];

        for(int i = 0; i < testCase; i++){
            if(max < triangle[testCase-1][i])
                max = triangle[testCase-1][i];
        }

        System.out.println(max);
    }
}
