import java.io.*;
import java.util.*;

public class Ex1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int cnt = 0;

        while(X > 0){
            cnt++;
            X -= cnt;
        }

        if(cnt % 2 == 0) {
            bw.write((cnt + X) + "/" + (1-X));
        }
        else {
            bw.write((1-X)+"/"+(cnt+X));
        }

        br.close();
        bw.close();
    }

}