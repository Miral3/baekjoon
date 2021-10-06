package ex4256;

/*
문제 이름: 트리
알고리즘: 트리, 분할 정복, 재귀
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int[] preorder;
    static int[] inorder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int teseCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < teseCase; i++) {
            int n = Integer.parseInt(br.readLine());

            preorder = new int[n];
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                preorder[j] = Integer.parseInt(input[j]);
            }

            inorder = new int[n];
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                inorder[j] = Integer.parseInt(input[j]);
            }
            postorder(0, n, 0);
            System.out.println();
        }

        br.close();
        bw.close();
    }

    public static void postorder(int start, int end, int current) {
       for(int i = start; i < end; i++) {
           if (preorder[current] == inorder[i]) {
               postorder(start, i, current + 1);
               postorder(i + 1, end, current + i - start + 1);
               System.out.print(inorder[i] + " ");
           }
       }
       return;
    }
}
