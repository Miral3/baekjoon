package Ex1544;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] cycle = new String[testCase];
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < testCase; i++) {
            cycle[i] = br.readLine();
        }

        int cnt = 0;
        for(int j = 0; j < cycle.length; j++) {
            if(!set.contains(cycle[j])) {
                cnt++;
            }
            for (int i = 1; i <= cycle[j].length(); i++) {
                String split = cycle[j].substring(i, cycle[j].length()) + cycle[j].substring(0, i);
                if(set.contains(split)) {
                    break;
                }
                set.add(split);
            }
        }
        System.out.println(cnt);
    }
}
