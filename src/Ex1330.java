import java.io.*;
import java.util.*;

public class Ex1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if(A > B){
            bw.write(">");
        }
        else if(A == B){
            bw.write("==");
        }
        else if(A < B){
            bw.write("<");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}


