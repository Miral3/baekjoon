package Ex2579;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int[] stair = new int[testCase+1];

        for(int i = 0 ; i < testCase; i++) {
            int input = Integer.parseInt(br.readLine());
            stair[i] = input;
        }

        if(testCase == 1)
            System.out.print(stair[0]);
        else if(testCase == 2)
            System.out.print(stair[0] + stair[1]);
        else
        {

        }
        br.close();
    }
}