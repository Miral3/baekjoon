package Ex1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        LinkedList<Integer> que = new LinkedList<>();

        for(int i = 1; i < N+1; i++) {
            que.add(i);
        }
        System.out.println(que.indexOf(3));

    }
}
