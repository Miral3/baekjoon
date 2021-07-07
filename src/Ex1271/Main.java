package Ex1271;

/*
문제 이름 : 엄청난 부자2
알고리즘 : 수학
자료구조 : 빅인트
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    BigInteger n = new BigInteger(input[0]);
    BigInteger m = new BigInteger(input[1]);

    System.out.println(n.divide(m));
    System.out.println(n.remainder(m));

    br.close();
    bw.close();
  }
}