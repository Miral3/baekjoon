import java.io.*;
import java.util.*;

public class Ex1929 { //에라스토테네스의 체 방식 이용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[N+1];
        int cnt = 0;

        for(int i = 0; i <= N; i++)
            arr[i] = 0;
        arr[1] = 1;

        for(int i = 2; i <= N; i++){
            for(int j = 2; i*j <= N; j++)
                arr[i * j] = 1;
        }

        for(int i = M; i <= N; i++) {
            if (arr[i] != 1) {
                cnt++;
                bw.write(i + "\n");
            }
        }
        bw.write(cnt+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}