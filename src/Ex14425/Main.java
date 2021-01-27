package Ex14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        ArrayList<String> list = new ArrayList<>();
        int listSize = Integer.parseInt(input[0]);
        int size = Integer.parseInt(input[1]) + listSize;
        int cnt = 0;

        for(int i = 0; i < size; i++) {
            String str = br.readLine();
            if(i < listSize) {
                list.add(str);
            }
            else if(list.contains(str)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
