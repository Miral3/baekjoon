import java.io.*;
import java.util.*;

public class Ex4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[246913];
        int length = arr.length-1;

        for(int i = 0; i <= length; i++)
            arr[i] = 0;
        arr[1] = 1;

        for(int i = 2; i <= length; i++){
            for(int j = 2; i*j <= length; j++)
                arr[i*j] = 1;
        }

        while(true){
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;

            if(N == 0)
                break;
            for(int i = N + 1; i <= 2*N; i++)
                if (arr[i] != 1)
                    cnt++;
            bw.write(cnt+"\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
}