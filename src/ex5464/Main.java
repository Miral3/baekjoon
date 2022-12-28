package ex5464;

/*
문제 이름: 주차장
알고리즘: 구현, 시뮬레이션
자료구조: 큐, 배열
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] parkingSpot = new int[n][2];
        for (int i = 0; i <n; i++) {
            parkingSpot[i][0] = Integer.parseInt(br.readLine());
        }

        int[][] car = new int[m + 1][2];
        for (int i = 1; i <= m; i++) {
            car[i][0] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        Queue<Integer> waitingCar = new LinkedList<>();
        for (int i = 0; i < m * 2; i++) {
            int carNum = Integer.parseInt(br.readLine());
            if (carNum < 0) {
                carNum *= -1;
                int spot = car[carNum][1];
                parkingSpot[spot][1] = 0;
                answer += parkingSpot[spot][0] * car[carNum][0];

                if (!waitingCar.isEmpty()) {
                    for (int j = 0; j < n; j++) {
                        if (parkingSpot[j][1] != 0) {
                            continue;
                        }
                        int waitingCarNum = waitingCar.poll();
                        parkingSpot[j][1] = waitingCarNum;
                        car[waitingCarNum][1] = j;
                        break;
                    }
                }
            } else {
                boolean isParked = false;
                for (int j = 0; j < n; j++) {
                    if (parkingSpot[j][1] != 0) {
                        continue;
                    }
                    parkingSpot[j][1] = carNum;
                    car[carNum][1] = j;
                    isParked = true;
                    break;
                }

                if (!isParked) {
                    waitingCar.add(carNum);
                }
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
