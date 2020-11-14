package Ex1764;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int testCase = Integer.parseInt(input[0]) + Integer.parseInt(input[1]);
        HashSet<String> set = new HashSet<>();
        LinkedList<String> result = new LinkedList<>();

        for(int i = 0; i < testCase; i++) {
            String dbj = br.readLine();
            if(!set.add(dbj)) {
                result.add(dbj);
            }
        }
        Collections.sort(result);
        bw.write(result.size()+"\n");

        for(String i : result) {
            bw.write(i+"\n");
        }
        bw.close();
        br.close();
    }
}
