package ex5676;

/*
문제 이름: 음주 코딩
알고리즘: 세그먼트 트리
자료구조: 트리
*/

import java.io.*;

public class Main {
    static int[] arr;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String input = "";
        while((input = br.readLine()) != null) {
            String[] input2 = input.split(" ");

            int n = Integer.parseInt(input2[0]);
            int k = Integer.parseInt(input2[1]);

            arr = new int[n + 1];
            tree = new int[n * 4];

            input2 = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                arr[i] = invert(Integer.parseInt(input2[i - 1]));
            }

            init(1, n, 1);


            for (int i = 0; i < k; i++) {
                input2 = br.readLine().split(" ");

                char command = input2[0].charAt(0);
                int idx = Integer.parseInt(input2[1]);
                int value = Integer.parseInt(input2[2]);

                if (command == 'C') {
                    int dif = invert(value);

                    update(1, n, 1, idx, dif);
                } else if (command == 'P') {
                    int result = mul(1, n, 1, idx, value);
                    if (result > 0) {
                        sb.append('+');
                    } else if (result < 0) {
                        sb.append('-');
                    } else {
                        sb.append('0');
                    }
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static int invert(int num) {
        if(num > 0) {
            return 1;
        } else if(num < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static int init(int start, int end, int node) {
        if(start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1);
    }

    public static int mul(int start, int end, int node, int left, int right) {
        if(end < left || right < start) {
            return 1;
        }

        if(left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return mul(start, mid, node * 2, left, right) * mul(mid + 1, end, node * 2 + 1, left, right);
    }

    public static int update(int start, int end, int node, int idx, int dif) {
        if(idx < start || idx > end) {
            return tree[node];
        }

        if(start == end) {
            return tree[node] = dif;
        }

        int mid = (start + end) / 2;
        return tree[node] = update(start, mid, node * 2, idx, dif) * update(mid + 1, end, node * 2 + 1, idx, dif);
    }
}
