package Ex1100;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 0;
        for(int i = 1; i <= 8; i++) {
            String[] input = br.readLine().split("");
            for(int j = 1; j <= 8; j++) {
                if(input[j-1].equals("F")) {
                    if(i%2 != 0 && j%2 != 0) {
                        cnt++;
                    }
                    else if(i%2 == 0 && j%2 == 0) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
