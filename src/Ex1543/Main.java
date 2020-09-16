package Ex1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String search = br.readLine();
        int cnt = 0;

        for(int i = 0; i < str.length()-search.length()+1;) {
            if(str.indexOf(search, i) != -1) {
                i = str.indexOf(search,i) + search.length();
                cnt++;
            }
            else {
                i++;
            }
        }
        System.out.println(cnt);
    }
}
