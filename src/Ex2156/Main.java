package Ex2156;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[] wine;
    static int[] wineData;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        wine = new int[10001];
        wineData = new int[10001];

        for(int i = 1; i <= testCase; i++) {
            int input = Integer.parseInt(br.readLine());
            wine[i] = input;
        }
        bw.write(dp(testCase)+"");

        br.close();
        bw.close();
    }
    public static int dp(int n) {
        wineData[1] = wine[1];
        wineData[2] = wine[1] + wine[2];

        for(int i = 3; i <= n; i++) {
            int once = wineData[i-2] + wine[i];
            int twice = wineData[i-3] + wine[i] + wine[i-1];
            int thrice = wineData[i-1];
            wineData[i] = Math.max(thrice,Math.max(once, twice));
        }
        return wineData[n];
    }
}
