package Ex1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int rgbPrice[][] = new int[testCase+1][3];

        for(int i=1; i <= testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j < 3; j++){
                int input = Integer.parseInt(st.nextToken());
                rgbPrice[i][j] = input;
            }
        }

        for(int i = 2; i <= testCase; i++)
        {
            rgbPrice[i][0] = Math.min(rgbPrice[i-1][1], rgbPrice[i-1][2]);
            rgbPrice[i][1] = Math.min(rgbPrice[i-1][0], rgbPrice[i-1][2]);
            rgbPrice[i][2] = Math.min(rgbPrice[i-1][0], rgbPrice[i-1][1]);
        }

        System.out.println(Math.min(rgbPrice[testCase][0],
                Math.min(rgbPrice[testCase][1], rgbPrice[testCase][2])));
    }
}
