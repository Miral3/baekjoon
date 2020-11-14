package Ex1418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 2; i <= N; i++) {
            if(primeFactor(i) < K) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static int primeFactor(int n) {
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = 0;
        }
        int idx = 0;
        for(int i = 2; i <= n; i++) {
            while(n%i == 0) {
                arr[idx++] = i;
                n /= i;
            }
        }
        if(n != 1) {
            arr[idx] = n;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        return arr[0];
    }
}
