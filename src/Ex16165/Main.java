package Ex16165;

/*
문제 이름 : 걸그룹 마스터 준석이
알고리즘 : 해시 맵, 연결 리스트
자료구조 : 해시 맵, 연결 리스트
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    HashMap<String, LinkedList<String>> listMap = new HashMap<>();

    for(int i = 0; i < N; i++) {
      String team = br.readLine();
      int num = Integer.parseInt(br.readLine());
      LinkedList<String> name = new LinkedList<>();

      for(int j = 0;j < num; j++) {
        String inputName = br.readLine();
        name.add(inputName);
      }
      Collections.sort(name);
      listMap.put(team, name);
    }

    for(int i = 0; i < M; i++) {
      String searchName = br.readLine();
      int type = Integer.parseInt(br.readLine());

      Iterator<String> keys = listMap.keySet().iterator();
      while( keys.hasNext() ) {
        String key = keys.next();
        if(listMap.get(key).contains(searchName) || key.equals(searchName)) {
          if(type == 0) {
            for(String value : listMap.get(key)) {
              bw.write(value + "\n");
            }
          } else if(type == 1) {
            bw.write(key + "\n");
          }
          break;
        }
      }
    }

    br.close();
    bw.close();
  }
}


