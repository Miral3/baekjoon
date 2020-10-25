package Ex1935;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        String input = br.readLine();
        Stack<Double> stack = new Stack<>();
        int[] insert = new int[testCase];

        for(int i = 0; i < testCase; i++) {
            insert[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < input.length(); i++) {
            char idx = input.charAt(i);
            double x = 0;
            double y = 0;
            double result;
            switch(idx) {
                case '+':   y = stack.pop();
                            x = stack.pop();
                            result = x+y;
                            stack.add(result);
                            break;
                case '-':   y = stack.pop();
                    x = stack.pop();
                    result = x-y;
                    stack.add(result);
                    break;
                case '*':   y = stack.pop();
                    x = stack.pop();
                    result = x*y;
                    stack.add(result);
                    break;
                case '/':   y = stack.pop();
                    x = stack.pop();
                    result = x/y;
                    stack.add(result);
                    break;
                    default: result = insert[(int)idx-65];
                    stack.add(result);
                    break;
            }
        }
        System.out.println(String.format("%.2f", stack.peek()));
    }
}
