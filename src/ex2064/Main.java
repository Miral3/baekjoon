package ex2064;

/*
문제 이름: IP 주소
알고리즘: 구현, 비트마스킹
자료구조: 배열, 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] ipAd = new String[n];
        // 입력값을 2진수로 바꿔서 배열에 저장(사이즈가 8보다 작으면 앞에 0을 채움)
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\.");
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < 4; j++) {
                String binary = Integer.toBinaryString(Integer.parseInt(input[j]));
                String format = String.format("%08d", Integer.parseInt(binary));
                sb.append(format);
            }

            ipAd[i] = sb.toString();
        }

        // ip주소를 앞에서부터 비교하면서 같으면 마스크에 1저장 다르면 그 뒤부터 다 0저장
        StringBuilder sbMask = new StringBuilder();
        for(int i = 0; i < 32; i++) {
            boolean isSame = true;
            for(int j = 1; j < n ; j++) {
                if(ipAd[j - 1].charAt(i) != ipAd[j].charAt(i)) {
                    isSame = false;
                    break;
                }
            }

            if(isSame) {
                sbMask.append("1");
            } else {
                for(int k = i; k < 32; k++) {
                    sbMask.append("0");
                }
                i = 32;
            }
        }

        // 8로 substring해서 2진수로 바꿔서 mask 변경
        String netAd = "";
        String netMask = "";
        for(int i = 0; i < 4; i++) {
            String split = sbMask.toString().substring(8 * i, 8 * (i + 1));
            String binary = split;
            int num = Integer.parseInt(split, 2);
            if(i == 3) {
                netMask += num;
            } else {
                netMask += num + ".";
            }
        }

        // mask와 ip주소 &로 비교하여 net주소 생성
        String[] arr = netMask.split("\\.");
        for(int i = 0; i < 4; i++) {
            String split = ipAd[0].substring(8 * i, 8 * (i + 1));
            String binary = split;
            int num = Integer.parseInt(split, 2);
            if(i == 3) {
                netAd += Integer.parseInt(arr[i]) & num;
            } else {
                netAd += (Integer.parseInt(arr[i]) & num) + ".";
            }
        }

        bw.write(netAd + "\n" + netMask + "\n");
        br.close();
        bw.close();
    }
}
