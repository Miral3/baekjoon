package ex5052;

/*
문제 이름 : 전화번호 목록
알고리즘 : 트라이
자료구조 : 트리
*/

import java.io.*;
public class Main {
  static class Trie {
    boolean end;
    boolean pass;
    Trie[] child;

    Trie() {
      end = false;
      pass = false;
      child = new Trie[10];
    }

    public boolean insert(String str, int idx) {
      if(end) {
        return false;
      }
      if(idx == str.length()) {
        end = true;
        if(pass) {
          return false;
        } else {
          return true;
        }
      } else {
        int next = str.charAt(idx) - '0';
        if(child[next] == null) {
          child[next] = new Trie();
          pass = true;
        }
        return child[next].insert(str, idx + 1);
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());
    while(testCase-- > 0) {
      int n = Integer.parseInt(br.readLine());
      Trie trie = new Trie();
      boolean result = true;
      String[] str = new String[n];
      for(int i = 0; i < n; i++) {
        str[i] = br.readLine();
      }
      for(int i = 0; i < n; i++) {
        result = trie.insert(str[i], 0);
        if(!result) {
          break;
        }
      }

      if(!result) {
        bw.write("NO\n");
      } else {
        bw.write("YES\n");
      }
    }

    br.close();
    bw.close();
  }
}
