package Ex1026;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int sum = 0;
        int[] A = new int[testCase];
        Integer[] B = new Integer[testCase];

        for(int i = 0; i < testCase; i++) {
            A[i] = sc.nextInt();
        }
        for(int i = 0; i < testCase; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for(int i = 0; i < testCase; i++) {
            sum += A[i] * B[i];
        }
        System.out.println(sum);
    }
}
