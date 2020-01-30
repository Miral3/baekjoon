package Ex10818;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int input = Integer.parseInt(br.readLine());
        int array[] = new int[input];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < input; i++){
            int val = Integer.parseInt(st.nextToken());
            array[i] = val;
        }

        int max = array[0];
        int min = array[0];

        for(int i = 0; i <= array.length-1; i++) {
            if(max < array[i])
                max = array[i];
            else if(min > array[i])
                min = array[i];
        }
        bw.write(min + " " + max);

        br.close();
        bw.close();
    }
}
