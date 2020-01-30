package Ex11021;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int arr[] = new int[input];


        for(int i=0;i<arr.length;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[i] = A+B;
        }

        for(int i=0;i<arr.length;i++)
            bw.write("Case #" + (i+1) + ": " + arr[i] + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
