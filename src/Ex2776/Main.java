package Ex2776;

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
      int caseOne = Integer.parseInt(br.readLine());
      String[] inputOne = br.readLine().split(" ");
      int[] inputOneInt = new int[caseOne];

      int caseTwo = Integer.parseInt(br.readLine());
      String[] inputTwo = br.readLine().split(" ");

      for(int j = 0; j < caseOne; j++) {
        inputOneInt[j] = Integer.parseInt(inputOne[j]);
      }
      Arrays.sort(inputOneInt);

      for(int j = 0; j < caseTwo; j++) {
        if(binaraySearch(Integer.parseInt(inputTwo[j]), inputOneInt)) {
          bw.write("1\n");
        } else {
          bw.write("0\n");
        }
      }
    }

    br.close();
    bw.close();
  }

  public static boolean binaraySearch(int findN, int[] arr) {
    boolean result = false;
    int left = 0;
    int right = arr.length-1;

    while(left <= right) {
      int mid = (left + right) / 2;
      if(arr[mid] > findN) {
        right = mid - 1;
      } else if(arr[mid] < findN) {
        left = mid + 1;
      } else {
        result = true;
        break;
      }
    }

    return result;
  }
}
