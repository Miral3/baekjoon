package Ex1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int[][] rgbPrice = new int[testCase+1][4];
        String[] price = br.readLine().split(" ");

        rgbPrice[1][1] = Integer.parseInt(price[0]);
        rgbPrice[1][2] = Integer.parseInt(price[1]);
        rgbPrice[1][3] = Integer.parseInt(price[2]);

        for(int i = 2; i < testCase+1; i++){
            price = br.readLine().split(" ");
            rgbPrice[i][1] = Math.min(rgbPrice[i-1][2], rgbPrice[i-1][3])+Integer.parseInt(price[0]);
            rgbPrice[i][2] = Math.min(rgbPrice[i-1][1], rgbPrice[i-1][3])+Integer.parseInt(price[1]);
            rgbPrice[i][3] = Math.min(rgbPrice[i-1][1], rgbPrice[i-1][2])+Integer.parseInt(price[2]);
        }
        System.out.println(Math.min(rgbPrice[testCase][1],Math.min(rgbPrice[testCase][2], rgbPrice[testCase][3])));
    }
}
