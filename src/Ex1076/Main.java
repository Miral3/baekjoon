package Ex1076;

/*
문제 이름 : 저항
알고리즘 : 문자열
자료구조 : 문자열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

class Node {
  String value;
  String multiply;

  public Node(String value, String multiply) {
    this.value = value;
    this.multiply = multiply;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    HashMap<String, Node> map = new HashMap<>();
    map.put("black", new Node("0", ""));
    map.put("brown", new Node("1", "0"));
    map.put("red", new Node("2", "00"));
    map.put("orange", new Node("3", "000"));
    map.put("yellow", new Node("4", "0000"));
    map.put("green", new Node("5", "00000"));
    map.put("blue", new Node("6", "000000"));
    map.put("violet", new Node("7", "0000000"));
    map.put("grey", new Node("8", "00000000"));
    map.put("white", new Node("9", "000000000"));

    String result = "";
    for(int i = 0; i < 3; i++) {
      String input = br.readLine();

      if(i < 2) {
        if(i == 0 && map.get(input).value.equals("0")) {
          continue;
        }
        result += map.get(input).value;
      } else {
        if(result.equals("0")) {
          result = "0";
        } else {
          result += map.get(input).multiply;
        }
      }
    }
    System.out.println(result);

    br.close();
    bw.close();
  }
}