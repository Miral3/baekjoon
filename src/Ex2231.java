import java.io.*;
import java.util.*;

public class Ex2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int j = 0;

        for(int i = N; i > 0; i--){
            if(i + i/100000 + (i/10000)%10 + (i/1000)%10 + (i/100)%10
                    +(i/10)%10 + i%10 == N) {
                arr[j] = i;
                j++;
            }
        }

        int min = arr[0];

        if(arr[0] == 0) {
            System.out.println("0");
            return;
        }
        else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < min && arr[i] != 0)
                    min = arr[i];
            }
            System.out.println(min);
        }
    }
}