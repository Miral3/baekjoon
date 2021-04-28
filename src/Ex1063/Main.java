package Ex1063;

/*
문제 이름 : 킹
알고리즘 : 구현
자료구조 : 문자열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    String kingLocation = input[0];
    String rockLocation = input[1];
    int N = Integer.parseInt(input[2]);
    int kingColumn = kingLocation.charAt(0) - 'A';
    int kingRow = kingLocation.charAt(1) - 49;
    int rockColumn = rockLocation.charAt(0) - 'A';
    int rockRow = rockLocation.charAt(1) - 49;

    for(int i = 0; i < N; i++) {
      String move = br.readLine();

      switch (move) {
        case "R":
          kingColumn++;
          if(kingColumn == rockColumn && kingRow == rockRow) {
            rockColumn++;

            if(kingColumn > 7 || rockColumn > 7) {
              kingColumn--;
              rockColumn--;
            }
          } else if(kingColumn > 7) {
            kingColumn--;
          }
          break;
        case "L":
          kingColumn--;
          if(kingColumn == rockColumn && kingRow == rockRow) {
            rockColumn--;

            if(kingColumn < 0 || rockColumn < 0) {
              kingColumn++;
              rockColumn++;
            }
          } else if(kingColumn < 0) {
            kingColumn++;
          }
          break;
        case "B":
          kingRow--;
          if(kingColumn == rockColumn && kingRow == rockRow) {
            rockRow--;

            if(kingRow < 0 || rockRow < 0) {
              kingRow++;
              rockRow++;
            }
          } else if(kingRow < 0) {
            kingRow++;
          }

          break;
        case "T":
          kingRow++;
          if(kingColumn == rockColumn && kingRow == rockRow) {
            rockRow++;

            if(kingRow > 7 || rockRow > 7) {
              kingRow--;
              rockRow--;
            }
          } else if(kingRow > 7) {
            kingRow--;
          }
          break;
        case "RT":
          kingColumn++;
          kingRow++;
          if(kingColumn == rockColumn && kingRow == rockRow) {
            rockColumn++;
            rockRow++;

            if(kingColumn > 7 || kingRow > 7 || rockColumn > 7
                || rockRow > 7) {
              kingColumn--;
              kingRow--;
              rockColumn--;
              rockRow--;
            }
          } else if(kingColumn > 7 || kingRow > 7) {
            kingColumn--;
            kingRow--;
          }
          break;
        case "LT":
          kingColumn--;
          kingRow++;
          if(kingColumn == rockColumn && kingRow == rockRow) {
            rockColumn--;
            rockRow++;

            if(kingColumn < 0 || kingRow > 7 || rockColumn < 0
                || rockRow > 7) {
              kingColumn++;
              kingRow--;
              rockColumn++;
              rockRow--;
            }
          } else if(kingColumn < 0 || kingRow > 7) {
            kingColumn++;
            kingRow--;
          }
          break;
        case "RB":
          kingColumn++;
          kingRow--;
          if(kingColumn == rockColumn && kingRow == rockRow) {
            rockColumn++;
            rockRow--;

            if(kingColumn > 7 || kingRow < 0 || rockColumn > 7
                || rockRow < 0) {
              kingColumn--;
              kingRow++;
              rockColumn--;
              rockRow++;
            }
          } else if(kingColumn > 7 || kingRow < 0) {
            kingColumn--;
            kingRow++;
          }
          break;
        case "LB":
          kingColumn--;
          kingRow--;
          if(kingColumn == rockColumn && kingRow == rockRow) {
            rockColumn--;
            rockRow--;

            if(kingColumn < 0 || kingRow < 0 || rockColumn < 0
                || rockRow < 0) {
              kingColumn++;
              kingRow++;
              rockColumn++;
              rockRow++;
            }
          } else if(kingColumn < 0 || kingRow < 0) {
            kingColumn++;
            kingRow++;
          }
          break;
      }
    }
    String king = "";
    king += (char)(kingColumn + 65);
    bw.write((king + (kingRow + 1)) + "\n");

    String rock = "";
    rock += (char)(rockColumn + 65);
    bw.write((rock + (rockRow + 1)) + "\n");
    br.close();
    bw.close();
  }
}
