package Ex1253;

/*
문제 이름 : 좋다
알고리즘 : 두 포인터
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    String[] input = br.readLine().split(" ");

    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }
    Arrays.sort(arr);

    int result = 0;
    for(int i = 0; i < N; i++) {
      int left = 0;
      int right = N-1;
      long sum = 0;

      while(left < right) {
        sum = arr[left] + arr[right];

        if(sum == arr[i]) {
          if(left != i && right != i) {
            result++;
            break;
          } if(left == i) {
            left++;
          } if(right == i) {
            right--;
          }
        } else if(sum < arr[i]) {
          left++;
        } else {
          right--;
        }
      }
    }

    bw.write(result + "\n");

    br.close();
    bw.close();
  }
}



