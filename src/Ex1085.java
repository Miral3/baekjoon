import java.io.*;
import java.util.StringTokenizer;

public class Ex1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int sub[] = new int[4];
        int min = 1000;

        if((x >= 1 && x <= w-1) && (y >= 1 && y <= h -1)
                && (w <= 1000) && (h <= 1000)) {
            sub[0] = x - 0;
            sub[1] = Math.abs(x - w);
            sub[2] = y - 0;
            sub[3] = Math.abs(y - h);

            for(int i = 0; i < sub.length; i++){
                if(min > sub[i])
                    min = sub[i];
            }
            System.out.println(min);
        }

    }
}