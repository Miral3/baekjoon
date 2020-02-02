package Ex2493;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Stack<Integer> oper = new Stack<>();
        Stack<Integer> result = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int input = Integer.parseInt(st.nextToken());
            oper.push(input);
        }

//        int size = oper.size() -2 ;
//
//        while(!oper.isEmpty()){
//            if(oper.peek() < oper.get(size)) {
//                result.push(size + 1);
//                oper.pop();
//                size--;
//            }
//            else if(oper.pop() < oper.get(size) && size == 0)
//                result.push(0);
//            else
//                size--;
//        }

        while (!result.isEmpty()) {
            System.out.print(result.pop() + " ");
        }
    }
}

