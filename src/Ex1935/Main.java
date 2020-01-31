package Ex1935;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine()); //피연산자의 갯수를 입력
        char[] input = br.readLine().toCharArray(); //후위표기식 입력
        Stack<Double> stack = new Stack<>(); //계산할 스택
        double[] numArr = new double[26]; //피연산자의 값을 저장할 배열
        int j = 0;

        for (int i = 0; i < num; i++) {
            double val = Double.parseDouble(br.readLine());
            numArr[i] = val;
        }

        for (int i = 0; i < input.length; i++) {
            double oper; //연산을 만나는 첫번째 피연산
            double result; //연산이랑 연속되는 2개의 피연산자들의 계산 값
            switch (input[i]) {
                case '+':
                    oper = stack.pop();
                    result = (stack.pop() + oper);
                    stack.push(result);
                    break;
                case '-':
                    oper = stack.pop();
                    result = (stack.pop() - oper);
                    stack.push(result);
                    break;
                case '*':
                    oper = stack.pop();
                    result = (stack.pop() * oper);
                    stack.push(result);
                    break;
                case '/':
                    oper = stack.pop();
                    result = (stack.pop() / oper);
                    stack.push(result);
                    break;
                default:
                    stack.push(numArr[(int)input[i] - 65]);
            }
        }
        System.out.println(String.format("%.2f",stack.pop()));
        br.close();
    }
}
