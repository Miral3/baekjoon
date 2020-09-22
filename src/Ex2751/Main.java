package Ex2751;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < testCase; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        for(int i = 0; i  < testCase; i++) {
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
