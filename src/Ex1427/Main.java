package Ex1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(String.valueOf(input).split("")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        for(int i = arr.length-1; i >= 0; i--){
            System.out.print(arr[i]);
        }
    }
}
