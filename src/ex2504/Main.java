package ex2504;

/*
문제 이름: 괄호의 값
알고리즘: 구현, 스택
자료구조: 스택
*/

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        Stack<String> calculate = new Stack<>();
        int result = 0;
        int sum = 0;
        for(int i = 0; i < input.length; i++) {
            String str = input[i];
            if(str.equals("(") || str.equals("[")) {
                stack.add(str);
                calculate.add(str);
            }
            else {
                if(stack.isEmpty()) {
                    System.out.println(0);
                    return;
                } else {
                    if(str.equals(")")) {
                        if(stack.peek().equals("(")) {
                            stack.pop();
                            while(true) {
                                if(calculate.peek().equals("(")) {
                                    calculate.pop();
                                    if(sum == 0) {
                                        calculate.add("2");
                                    } else {
                                        result = 2 * sum;
                                        calculate.add(Integer.toString(result));
                                        sum = 0;
                                    }
                                    break;
                                } else {
                                    sum += Integer.parseInt(calculate.pop());
                                }
                            }
                        } else {
                            System.out.println(0);
                            return;
                        }
                    } else {
                        if(stack.peek().equals("[")) {
                            stack.pop();
                            while(true) {
                                if(calculate.peek().equals("[")) {
                                    calculate.pop();
                                    if(sum == 0) {
                                        calculate.add("3");
                                    } else {
                                        result = 3 * sum;
                                        calculate.add(Integer.toString(result));
                                        sum = 0;
                                    }
                                    break;
                                } else {
                                    sum += Integer.parseInt(calculate.pop());
                                }
                            }
                        } else {
                            System.out.println(0);
                            return;
                        }
                    }
                }
            }
        }

        if(!stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        result = 0;
        while(!calculate.isEmpty()) {
            result += Integer.parseInt(calculate.pop());
        }

        System.out.println(result);

        br.close();
        bw.close();
    }
}
