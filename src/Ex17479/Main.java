package Ex17479;

/*
문제 이름 : 정식당
알고리즘 : 해시맵
자료구조 : 해시맵
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    HashMap<String, Menu> hash = new HashMap<>();
    boolean orderSp = false;
    long nomalMenu = 0;
    long totalPrice = 0;
    int serviceCnt = 0;
    String[] input = br.readLine().split(" ");
    int A = Integer.parseInt(input[0]);
    int B = Integer.parseInt(input[1]);
    int C = Integer.parseInt(input[2]);
    int len = A + B + C;

    for(int i = 0; i < len; i++) {
      input = br.readLine().split(" ");
      String dish = input[0];
      int price = 0;
      String type = "";
      if(input.length != 1) {
        price = Integer.parseInt(input[1]);
      }

      if(i < A) {
        type = "normal";
      } else if(i < A + B) {
        type = "special";
      } else {
        type = "service";
      }
      hash.put(dish, new Menu(type, price));
    }


    int N = Integer.parseInt(br.readLine());
    for(int i = 0; i < N; i++) {
      String order = br.readLine();
      Menu menu = hash.get(order);
      String orderType = menu.type;
      int orderPrice = menu.price;

      if(orderType.equals("normal")) {
        nomalMenu += orderPrice;
      }
      if(orderType.equals("special")) {
        orderSp = true;
      }
      if(orderType.equals("service")) {
        serviceCnt++;
      }
      totalPrice += orderPrice;
    }

    if(nomalMenu < 20000) {
      if(orderSp) {
        System.out.println("No");
        return;
      }
    }
    if(totalPrice < 50000) {
      if(serviceCnt > 0) {
        System.out.println("No");
        return;
      }
    }
    if(serviceCnt > 1) {
      System.out.println("No");
      return;
    }
    System.out.println("Okay");
    br.close();
  }
  public static class Menu {
    String type;
    int price;

    public Menu(String type, int price) {
      this.type = type;
      this.price = price;
    }
  }
}
