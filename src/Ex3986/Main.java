package Ex3986;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i< num; i++){
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            char temp;
            for(int j = 0; j < input.length(); j++){
                temp = input.charAt(j);
                if(stack.isEmpty()){
                    {
                        stack.push(temp);
                    }
                }
                else{
                    if(temp == stack.peek())
                        stack.pop();
                    else
                        stack.push(temp);
                }

            }
            if(stack.isEmpty())
                count++;
        }
        System.out.println(count);
        br.close();
    }
}