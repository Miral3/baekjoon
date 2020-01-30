import java.io.*;
import java.util.*;

public class Ex3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int R = Integer.parseInt(br.readLine());

        double Euclid = Math.PI * R * R;
        double Taxi = 2 * R * R;

        System.out.println(String.format("%.6f",Euclid));
        System.out.println(String.format("%.6f",Taxi));
    }
}