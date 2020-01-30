import java.io.*;
import java.util.*;

public class Ex9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());


        if (A >= 0 && A <= 100) {
            if (A >= 90 && A <= 100)
                bw.write("A");
            else if (A >= 80 && A <= 89)
                bw.write("B");
            else if (A >= 70 && A <= 79)
                bw.write("C");
            else if (A >= 60 && A <= 69)
                bw.write("D");
            else
                bw.write("F");
        } else {
            System.out.println("0에서 100사이의 정수를 입력하세요");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}


