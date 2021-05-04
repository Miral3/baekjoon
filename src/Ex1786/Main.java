package Ex1786;

/*
문제 이름 : 찾기
알고리즘 : KMP
자료구조 : 배열 리스트, 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String T = br.readLine();
    String P = br.readLine();

    ArrayList<Integer> answer = kmp(T, P);

    bw.write(answer.size() + "\n");
    for(Integer val : answer) {
      bw.write(val + "\n");
    }

    br.close();
    bw.close();
  }
  public static int[] getPi(String pattern) {
    int m = pattern.length();
    int j = 0;
    int[] pi = new int[m];
    String[] p = pattern.split("");

    for(int i = 1; i < m; i++) {
      while(j > 0 && !p[i].equals(p[j])) {
        j = pi[j-1];
      }
      if(p[i].equals(p[j])) {
        pi[i] = ++j;
      }
    }

    return pi;
  }

  public static ArrayList<Integer> kmp(String text, String pattern) {
    ArrayList<Integer> ans = new ArrayList<>();
    int[] pi = getPi(pattern);
    int n = text.length();
    int m = pattern.length();
    int j = 0;
    String[] t = text.split("");
    String[] p = pattern.split("");

    for(int i = 0; i < n; i++) {
      while(j > 0 && !t[i].equals(p[j])) {
        j = pi[j-1];
      }
      if(t[i].equals(p[j])) {
        if(j == m-1) {
          ans.add(i-m+2);
          j = pi[j];
        } else {
          j++;
        }
      }
    }
    return ans;
  }
}
