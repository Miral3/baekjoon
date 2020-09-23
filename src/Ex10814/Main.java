package Ex10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[][] arr = new String[testCase][2];

        for(int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = input[0];
            arr[i][1] = input[1];
        }
        Arrays.sort(arr, Comparator.comparingInt(o1 -> Integer.parseInt(o1[0])));

        for(int i = 0; i < testCase; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
