package ex1269;

/*
문제 이름: 대칭 차집합
알고리즘: 해시 맵
자료구조: 해시 맵
*/

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] n = br.readLine().split(" ");
        String[] inputA = br.readLine().split(" ");
        String[] inputB = br.readLine().split(" ");
        int lenA = Integer.parseInt(n[0]);
        int lenB = Integer.parseInt(n[1]);
        int[] A = new int[lenA];
        int[] B = new int[lenB];

        for(int i = 0; i < lenA; i++) {
            A[i] = Integer.parseInt(inputA[i]);
        }
        for(int i = 0; i < lenB; i++) {
            B[i] = Integer.parseInt(inputB[i]);
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i = 0; i < lenA; i++) {
            set1.add(A[i]);
        }

        for(int i = 0; i < lenB; i++) {
            set2.add(B[i]);
        }

        int cnt = 0;
        for(int i = 0; i < lenB; i++) {
            if(!set1.contains(B[i])) {
                cnt++;
            }
        }

        for(int i = 0; i < lenA; i++) {
            if(!set2.contains(A[i])) {
                cnt++;
            }
        }

        System.out.println(cnt);

        br.close();
        bw.close();
    }
}
