package Ex1009;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int remainder = b%4;
            int ans = 0;

            if(a%10 == 1) {
                bw.write("1\n");
                continue;
            }
            if(a%10 == 0) {
                bw.write("10\n");
                continue;
            }

            if(remainder == 0) {
                ans = (int)Math.pow(a, 4)%10;
                bw.write(ans + "\n");
            } else {
                ans = (int)Math.pow(a, remainder)%10;
                bw.write(ans + "\n");
            }
        }

        br.close();
        bw.close();
    }
}
