package Ex1037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[num];

        for(int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);
        if(num < 2) {
            System.out.println(arr[0] * arr[0]);
        }
        else {
            System.out.println(arr[0] * arr[arr.length-1]);
        }
    }
}
