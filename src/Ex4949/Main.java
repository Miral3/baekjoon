package Ex4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
       char[] input;

        while((input = br.readLine().toCharArray()).length != 1 && input[0] != '.') {
            stack.clear();
            for(int i  = 0; i < input.length; i++) {
                if(input[i] == '(' || input[i] == '[') {
                    stack.push(input[i]);
                }
                else if(input[i] == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        stack.push('a');
                        break;
                    }
                    else if(!stack.isEmpty() || stack.peek() == '(') {
                        stack.pop();
                    }
                }
                else if(input[i] == ']') {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        stack.push('a');
                        break;
                    }
                    else if(!stack.isEmpty() || stack.peek() == '[') {
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty()) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }
}
