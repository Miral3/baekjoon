package Ex9935;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        for(int i = input.length - 1; i >= 0; i--) {
            stack.push(input[i]);
            if(stack.peek() == bomb[0] && stack.size() >= bomb.length){
                boolean isBomb = true;
            }
        }

        int size = stack.size();

        if(stack.isEmpty())
            System.out.print("FRULA");
        else
            for(int i = 0 ; i < size; i++)
                System.out.print(stack.pop());

        br.close();
    }
}
