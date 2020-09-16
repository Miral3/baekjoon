package Ex1544;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] cycle = new String[testCase];
        LinkedList<String> list = new LinkedList<>();

        for(int i = 0; i < testCase; i++) {
            cycle[i] = br.readLine();
        }

        int cnt = 0;
        for(int j = 0; j < cycle.length; j++) {
            if(!list.contains(cycle[j])) {
                cnt++;
            }
            for (int i = 1; i <= cycle[j].length(); i++) {
                String split = cycle[j].substring(i, cycle[j].length()) + cycle[j].substring(0, i);
                if(list.contains(split)) {
                    break;
                }
                list.add(split);
            }
        }
        System.out.println(cnt);
    }
}
