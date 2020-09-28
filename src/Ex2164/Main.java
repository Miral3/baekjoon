package Ex2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            deque.add(i);
        }

        while(deque.size() != 1) {
            deque.remove();
            int rm = deque.remove();
            deque.addLast(rm);
        }
        System.out.println(deque.peek());
    }
}
