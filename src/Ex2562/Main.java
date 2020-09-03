package Ex2562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int max = 0;
        int idx = 0;

        for(int i = 0; i < arr.length; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;

            if(max < arr[i]) {
                max = arr[i];
                idx = i;
            }
        }
        System.out.println(max);
        System.out.println(idx+1);
    }
}
