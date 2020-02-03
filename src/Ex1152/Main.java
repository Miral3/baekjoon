package Ex1152;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        String input[] = br.readLine().split(" ");

        for(int i = 0; i < input.length; i++) {
            if (input[i] == null || input[i].length() == 0) {
                count++;
            }
        }
        System.out.println(input.length-count);
        br.close();
    }
}