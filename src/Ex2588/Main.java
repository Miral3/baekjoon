package Ex2588;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());


        bw.write(A*(B%10) + "\n");
        bw.write(A*((B%100)/10) + "\n");
        bw.write(A*(B/100) + "\n");
        bw.write(A*B + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
