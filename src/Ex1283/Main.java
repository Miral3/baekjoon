package Ex1283;

/*
문제 이름 : 단축키 지정
알고리즘 : 구현
자료구조 : 문자열, 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String[] str = new String[N];
    HashSet<Character> hotKey = new HashSet<>(); // 단축키를 저장하는 HashSet

    for(int i = 0; i < N; i++) {
      str[i] = br.readLine();
    }

    for(int i = 0; i < N; i++) {
      int index = 0; // 문자열에서 단축키로 지정된 알파벳의 위치
      String[] strSplit = str[i].split(" "); // 공백으로 단어 구분
      StringBuilder sb = new StringBuilder(str[i]); // 대괄호 삽입을 위해 StringBuilder 생성
      boolean registerHk = false; // 각 문자열이 단축키가 지정됐는지 여부파악
      char convertToUp; // 대소문자 구분하지 않기 위해 변환한 알파벳
      int len = 0;

      /* 먼저 문자열을 공백으로 단어로 나눈 뒤 단어 수 만큼 돌면서 각 단어의 첫 번째 알파벳을 확인*/
      for(int j = 0; j < strSplit.length; j++) {
        char firstChar = strSplit[j].charAt(0); // 단어의 첫 알파벳만 뽑아옴
        convertToUp = Character.toUpperCase(firstChar); // 대소문자 구분하지 않기 위해 변환
        if(j > 0) {
          len += strSplit[j-1].length() + 1;
        }
        index = len; // 문자열에서 단축키로 지정된 알파벳의 위치

        if(!hotKey.contains(convertToUp)) { // 중복되지 않은 단축키면
          hotKey.add(convertToUp); // HashSet에 삽입
          registerHk = true; // 해당 문자열은 단축키가 지정 됌
          sb.insert(index, "["); // 단축키로 지정된 알파벳의 좌 우에 대괄호 삽입
          sb.insert(index + 2, "]");
          bw.write(sb + "\n"); // 출력
          break;
        }
      }

      /* 만약 모든 단어의 첫 글자가 이미 지정이 되어있다면 왼쪽에서부터 차례대로
      알파벳을 보면서 단축키로 지정 안 된 것이 있다면 단축키로 지정한다. */
      if(!registerHk) {
        Loop: // for문 2개를 한번에 탈출하기 위해 라벨명을 지정
        for(int j = 0; j < strSplit.length; j++) { // 단어 갯수만큼
          for(int k = 0; k < strSplit[j].length(); k++) { // 해당 단어의 길이만큼
            char target = strSplit[j].charAt(k); // 단어를 왼쪽부터 차례대로 본다
            convertToUp = Character.toUpperCase(target);
            index = sb.indexOf(target+"");

            if(!hotKey.contains(convertToUp)) {
              hotKey.add(convertToUp);
              registerHk = true;
              sb.insert(index, "[");
              sb.insert(index + 2, "]");
              bw.write(sb + "\n");
              break Loop;
            }
          }
        }
      }

      /* 위의 두 과정을 거쳤는데도 단축키가 지정되지 않았다면 그냥 출력*/
      if(!registerHk) {
        bw.write(sb + "\n");
      }
    }

    br.close();
    bw.close();
  }
}
