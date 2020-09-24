package Ex3036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] arr = new int[testCase];
        String[] input = br.readLine().split(" ");

        for(int i = 0; i < testCase; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }


        for(int i = 1; i < testCase; i++) {
            int ans = GCD(arr[0], arr[i]);
            System.out.println(arr[0]/ans + "/" + arr[i]/ans);
        }
    }

    public static int GCD(int x, int y) {
        int n = 0;
        if(y > x) {
            swap(x, y);
        }
        while(x % y != 0) {
            n = x%y;
            x =  y;
            y = n;
        }
        return y;
    }

    public static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }
}
