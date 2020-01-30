import java.io.*;
import java.util.*;

public class Ex1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];
        int cnt = 0;
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(CheckDeciaml(arr[i]))
                cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean CheckDeciaml(int n){
        int cnt = 0;

        for(int i = 1; i <= n; i++){
            if(n % i == 0)
                cnt++;
        }
        if(cnt > 2 || n == 1)
            return false;
        else
            return true;
    }
}