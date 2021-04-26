package Ex5052;

/*
문제 이름 : 전화번호 목록
알고리즘 : 문자열, 정렬
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

    int testCase = Integer.parseInt(br.readLine());

    for(int i = 0; i < testCase; i++) {
      int n = Integer.parseInt(br.readLine());
      String[] arr = new String[n];
      boolean result = true;

      for(int j = 0; j < n; j++) {
        arr[j] = br.readLine();
      }

      Arrays.sort(arr);

      for(int j = 0; j < n-1; j++) {
        int now = arr[j].length();
        int next = arr[j+1].length();

        if(now < next) {
          if(arr[j+1].startsWith(arr[j])) {
            result = false;
            break;
          }
        }
      }
      if(result) {
        bw.write("YES\n");
      } else {
        bw.write("NO\n");
      }
    }
    br.close();
    bw.close();
  }
}
