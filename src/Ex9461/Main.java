package Ex9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        long arr[] = new long[101];

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;

        for(int i = 3; i < arr.length; i++){
            arr[i] = arr[i-3] + arr[i-2];
        }

        for(int i = 0; i < testCase; i++){
            int input = Integer.parseInt(br.readLine());
            System.out.println(arr[input-1]);
        }
    }
}
