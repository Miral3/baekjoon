package Ex18258;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        LinkedList<Integer> que = new LinkedList<>();

        for(int i = 0; i <testCase; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    que.add(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if(que.isEmpty()) {
                    bw.write("-1\n");
                     } else {
                        bw.write(que.poll() + "\n");
                    }
                    break;
                case "size":
                    bw.write(que.size() + "\n");
                    break;

                case "empty":
                    if(que.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if(que.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(que.peekFirst() + "\n");
                    }
                    break;
                case "back":
                    if(que.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(que.peekLast() + "\n");
                    }
                    break;
            }
        }
        br.close();
        bw.close();
    }
}
