package Ex1918;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Stack<Character> stackAlp = new Stack<>();
        Stack<Character> stackAri = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            switch (input[i]) {
                case '+':
                case '-':
                    while (!stackAri.isEmpty() && stackAri.peek() != '(') {
                        stackAlp.push(stackAri.pop());
                    }
                    stackAri.push(input[i]);
                    break;
                case '*':
                case '/':
                    while (!stackAri.isEmpty() && (stackAri.peek() == '/' || stackAri.peek() == '*')) {
                        stackAlp.push(stackAri.pop());
                    }
                    stackAri.push(input[i]);
                    break;
                case '(':
                    stackAri.push(input[i]);
                    break;
                case ')':
                    while (stackAri.peek() != '(') {
                        stackAlp.push(stackAri.pop());
                    }
                    stackAri.pop();
                    break;
                default:
                    stackAlp.push(input[i]);
                    break;
            }
            if(i == input.length-1){
                while(stackAri.size() != 0)
                    stackAlp.push(stackAri.pop());
            }
        }

//        while (stackAri.size() > 0) {
//        while(!stackAri.isEmpty()) {
//            stackAlp.push(stackAri.pop());
//        }

//        Character[] arr = stackAlp.toArray(new Character[stackAlp.size()]);
        Object[] stack2Arr=stackAlp.toArray();

        for (int i = 0; i < stack2Arr.length; i++)
            System.out.print(stack2Arr[i]);
//            bw.write(stack2Arr[i]+"");

        br.close();
    }
}
