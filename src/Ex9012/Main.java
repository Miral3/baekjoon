package Ex9012;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;
            char temp;
            for (int j = 0 ; j < input.length(); j++) {
                temp = input.charAt(j);
                if(temp == '('){
                    stack.push(temp);
                }
                else if(temp == ')'){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    else{
                        isVPS = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty())
                isVPS = false;
            if(isVPS)
                System.out.println("YES");
            else
                System.out.println("NO");
        }


        br.close();
    }
}
