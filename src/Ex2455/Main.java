package Ex2455;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer[] arr = new Integer[4];
        int remain = 0;

        for(int i = 0; i < 4; i++) {
            String[] input = br.readLine().split(" ");
            int let = Integer.parseInt(input[0]);
            int ride = Integer.parseInt(input[1]);
            remain = remain - let + ride;
            arr[i] = remain;
        }

        Arrays.sort(arr, Collections.reverseOrder());
        bw.write(arr[0] + "\n");

        br.close();
        bw.close();
    }
}
