package Ex4344;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());


        for(int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int sum = 0;
            int avg;
            int cnt = 0;
            double stuAvg;

            for(int j = 1;j <= N; j++) {
                sum += Integer.parseInt(input[j]);
            }
            avg = sum / N;

            for(int k = 1; k <= N; k++) {
                if(Integer.parseInt(input[k]) > avg) {
                    cnt++;
                }
            }
            stuAvg = ((double)cnt/(double)N)*100.0;
            System.out.println(String.format("%.3f", stuAvg) + "%");
        }
    }
}
