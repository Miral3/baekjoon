import java.io.*;
import java.util.*;

public class Ex2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int min = 10001, cnt = 0, sum = 0;

        for(int i = N; i <= M; i++){
            for(int j = 2; j <i; j++){
                if(i % j == 0)
                    cnt++;
            }
            if(cnt == 0 && i != 1){
                sum += i;
                if(min > i)
                    min = i;
            }
            cnt = 0;
        }
        if(min == 10001){
            System.out.println("-1");
        }
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}