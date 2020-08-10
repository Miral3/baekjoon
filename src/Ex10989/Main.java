package Ex10989;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int testCase = Integer.parseInt(br.readLine());
        int[] arr = new int[testCase];
        int[] sort = new int[testCase];
        int range;
        int[] arrCount;

        range = 0;
        for(int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            if(range < arr[i]) {
                range = arr[i];
            }
        }

        arrCount = new int[range + 1];

        for(int i = 0; i < testCase; i++) {
            arrCount[arr[i]]++;
        }

        for(int i = 1; i <= range; i++) {
            arrCount[i] += arrCount[i-1];
        }

        for(int i = testCase-1; i >= 0; i--) {
            sort[arrCount[arr[i]]-1] = arr[i];
            arrCount[arr[i]]--;
        }

        for(int i = 0; i < testCase; i++) {
            bw.write(String.valueOf(sort[i]));
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
