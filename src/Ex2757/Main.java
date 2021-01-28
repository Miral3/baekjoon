package Ex2757;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            while(true) {
                String[] input = br.readLine().split("R|C");
                StringBuffer strBuffer = new StringBuffer();
                int A = Integer.parseInt(input[1]);
                int B = Integer.parseInt(input[2]);
                String answer = "";
                if(A==0 && B == 0) {
                    break;
                }
                while (B > 0) {
                    int remain = B % 26;
                    B /= 26;

                    if (remain == 0) {
                        answer += 'Z';
                    } else {
                        answer += (char) (remain + 64);
                    }
                    if (remain == 0) {
                        B--;
                    }

                }
                strBuffer.append(answer);
                bw.write(strBuffer.reverse().toString());
                bw.write(A+"\n");
            }
            bw.close();
            br.close();
    }
}
