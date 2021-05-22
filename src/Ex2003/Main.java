package Ex2003;

/*
문제 이름 : 수들의 합2
알고리즘 : 두 터포인
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    int[] arr = new int[N];

    input = br.readLine().split(" ");
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    int left = 0;
    int right = 0;
    int sum = 0;
    int ans = 0;
    while (true){
      if(sum >= M){
        sum -= arr[left++];
      } else if(right ==N){
        break;
      } else {
        sum += arr[right++];
      }
      if(sum == M){
        ans++;
      }
    }
    System.out.println(ans);
    br.close();
    bw.close();
  }
}

