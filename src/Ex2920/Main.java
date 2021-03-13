package Ex2920;

/*
문제 이름 : 음계
알고리즘 : 구현
자료구조 : 배열
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    String str = Arrays.toString(input);

    if(str.equals("[1, 2, 3, 4, 5, 6, 7, 8]")) {
      bw.write("ascending" + "\n");
    } else if(str.equals("[8, 7, 6, 5, 4, 3, 2, 1]")) {
      bw.write("descending" + "\n");
    } else {
      bw.write("mixed" + "\n");
    }
    br.close();
    bw.close();
  }
}
