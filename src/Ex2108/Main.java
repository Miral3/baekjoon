package Ex2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] arsg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int testCase = Integer.parseInt(br.readLine());
        int[] arr = new int[testCase];
        int[] sta = new int[4];
        int[] arrCount;
        int[] arrCheck;
        int sum;
        int avg;
        int max;
        int range;
        int j;
        int mode;
        double avgDouble;
        boolean check;

        for(int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /* 산술평균 */
        sum = 0;
        for(int i = 0; i < testCase; i++) {
            sum += arr[i];
        }
        avgDouble = ((double)sum / (double) testCase);
        Math.round(avgDouble * 1 / 1.0); // 소수점 이하 첫째 자리에서 반올림
        avg = Integer.parseInt(String.valueOf(Math.round(avgDouble))); // 형 변환
        sta[0] = avg;

        /* 중앙값 */
        Arrays.sort(arr);
        sta[1] = arr[(testCase-1) / 2];

        /* 최빈값 */
        arrCount = new int[8001]; // 음수는 절대값을 취하고 4000을 더해서 체크한다.
        arrCheck = new int[testCase]; // 최빈값이 여러개 있을 때 두 번째로 작은 값 출력
        max = 0; // 빈도수를 나타내는 변수
        check = false; // 빈도수가 여러 개 있는지 체크
        mode = 0; // 최빈값인 원소
        j = 0;
        for(int i = 0; i < testCase; i++) {
            if(arr[i] >= 0) {
                arrCount[arr[i]]++;
            }
            else {
                arrCount[Math.abs(arr[i])+4000]++;
            }
        }

        for(int i = 0; i < arrCount.length; i++) {
            if(max < arrCount[i]) {
                max = arrCount[i];
                mode = i;
            }
            else if(max != 0 && max == arrCount[i]) {
                check = true;
            }
        }

        if(check) {
            for (int i = 0; i < arrCount.length; i++) {
                if (arrCount[i] != 0 && arrCount[i] == max) {
                    if (i > 4000) {
                        arrCheck[j] = 4000 - i;
                        j++;
                    } else {
                        arrCheck[j] = i;
                        j++;
                    }
                }
            }
            Arrays.sort(arrCheck);
            if(arrCheck.length == 1){
                sta[2] = arrCheck[0];
            }
            else {
                sta[2] = arrCheck[1];
            }
        }
        else {
            sta[2] = mode;
        }


        /* 범위 */
        if(testCase != 1) {
            range = arr[testCase-1] - arr[0];
        }
        else {
            range = 0;
        }
        sta[3] = range;

        for(int i = 0; i < sta.length; i++) {
            System.out.println(sta[i]);
        }
    }
}
