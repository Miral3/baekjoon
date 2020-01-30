package Ex10828;

import java.io.*;
import java.util.*;

public class Main {
    static Stack<Integer> stack = new Stack<>();

    public static int push(int num){
        return stack.push(num);
    }
    public static void pop(){
        if(stack.isEmpty())
            System.out.println("-1");
        else
            System.out.println(stack.pop());
    }
    public static void size(){
        System.out.println(stack.size());
    }
    public static void empty(){
        if(stack.isEmpty())
            System.out.println("1");
        else
            System.out.println("0");
    }
    public static void top(){
        if(stack.isEmpty())
            System.out.println("-1");
        else
            System.out.println(stack.peek());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case"empty":
                    empty();
                    break;
                case "top":
                    top();
                    break;
            }

        }

        bw.flush();
        br.close();
        bw.close();
    }
}
