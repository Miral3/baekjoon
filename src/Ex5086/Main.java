package Ex5086;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = 1;
        int y = 1;
        while(true) {
            String[] input = br.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            if(x == 0 && y == 0) {
                break;
            }
            if (y % x == 0) {
                bw.write("factor\n");
            }
            else if(x % y == 0) {
                bw.write("multiple\n");
            }
            else {
                bw.write("neither\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
