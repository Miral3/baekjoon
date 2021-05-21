package Ex11728;

/*
문제 이름 : 배열 합치기
알고리즘 : 두 포인터
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

    String[] size = br.readLine().split(" ");
    int firstLen = Integer.parseInt(size[0]);
    int secondLen = Integer.parseInt(size[1]);

    String[] firstInput = br.readLine().split(" ");
    int[] firstArr = new int[firstLen];
    for(int i = 0; i < firstLen; i++) {
      firstArr[i] = Integer.parseInt(firstInput[i]);
    }

    String[] secondInput = br.readLine().split(" ");
    int[] secondArr = new int[secondLen];
    for(int i = 0; i < secondLen; i++) {
      secondArr[i] = Integer.parseInt(secondInput[i]);
    }

    int firstPoint = 0;
    int secondPoint = 0;
    int idx = 0;
    int[] ans = new int[firstLen + secondLen];
    while(true) {
      if(firstArr[firstPoint] > secondArr[secondPoint]) {
        ans[idx++] = secondArr[secondPoint];
        secondPoint++;
        if(secondPoint == secondLen) {
          while(firstPoint != firstLen) {
            ans[idx++] = firstArr[firstPoint++];
          }
          break;
        }
      } else {
        ans[idx++] = firstArr[firstPoint];
        firstPoint++;
        if(firstPoint == firstLen) {
          while (secondPoint != secondLen) {
            ans[idx++] = secondArr[secondPoint++];
          }
          break;
        }
      }
    }

    for(int i = 0; i < ans.length; i++) {
      bw.write(ans[i] + " ");
    }
    br.close();
    bw.close();
  }
}

