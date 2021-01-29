package Ex1292;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < 45; i++) {
            for (int j = 0; j < i + 1; j++) {
                list.add(i + 1);
            }
        }

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for (int i = A - 1; i < B; i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}
