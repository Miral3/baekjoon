import java.io.*;
import java.util.*;

public class Ex2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        if( N == 4 || N == 7) {
            System.out.println("-1");
            return;
        }

        cnt = N / 5;
        switch (N % 5)
        {
            case 0:
                bw.write(cnt+"\n");
                break;
            case 1:
            case 3:
                bw.write(cnt + 1 + "\n");
                break;
            case 2:
            case 4:
                bw.write(cnt + 2 + "\n");
                break;
        }
        br.close();
        bw.close();
    }
}