package Ex1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        String[] input;

        for(int i = 0; i < testCase; i++) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int r1 = Integer.parseInt(input[2]);
            int x2 = Integer.parseInt(input[3]);
            int y2 = Integer.parseInt(input[4]);
            int r2 = Integer.parseInt(input[5]);

            double degreeCenter = Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
            double degreeRadous = Math.abs(r1-r2);
            double sumRadius = r1+r2;

            if(sumRadius < degreeCenter || degreeRadous > degreeCenter) {
                System.out.println(0);
            }
            else if(sumRadius == degreeCenter || (degreeRadous == degreeCenter &&
                    degreeCenter != 0)) {
                System.out.println(1);
            }
            else if(degreeRadous < degreeCenter && sumRadius > degreeCenter) {
                System.out.println(2);
            }
            else {
                System.out.println(-1);
            }
        }
    }
}
