package Ex14650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public  static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[10];

    arr[2] = 2;

    for(int i = 3; i < arr.length; i++) {
      arr[i] = arr[i-1] * 3;
    }

    bw.write(arr[N] + "");

    br.close();
    bw.close();
  }
}
