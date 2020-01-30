package Ex9935;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String explosive = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i = input.length() - 1; i >= 0; i--)
            stack.push(input.charAt(i));

        for(int i = 0; i < input.length(); i++)
            bw.write(stack.pop());

        bw.flush();
        br.close();
        bw.close();
    }
}
