package Ex10773;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int testCase = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 0; i < testCase; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                stack.pop();
            }
            else {
                stack.push(input);
            }
        }

        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        bw.write(sum + "\n");

        br.close();
        bw.close();
    }
}
