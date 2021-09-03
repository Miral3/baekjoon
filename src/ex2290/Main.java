package ex2290;

/*
문제 이름: LCD Test
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        String[] n = input[1].split("");

        int len = n.length;
        int[] num = new int[len];
        for(int i = 0 ; i < len; i++) {
            num[i] = Integer.parseInt(n[i]);
        }

        for(int i = 0; i < (s * 2) + 3; i++) {
            int target = 0;
            for(int j = 0; j < len; j++) {
                target = num[j]; // 어떤 숫자인지
                if(i == 0) { // 숫자의 맨 위
                    if(target == 1) {
                        for(int k = 0; k < s + 2; k++) {
                            bw.write(" ");
                        }
                    } else if(target == 4) {
                        for(int k = 0; k < s + 2; k++) {
                            bw.write(" ");
                        }
                    } else {
                        for(int k = 0; k < s + 2; k++) {
                            if(k == 0 || k == s + 1) {
                                bw.write(" ");
                            } else {
                                bw.write("-");
                            }
                        }
                    }
                    bw.write(" "); // 숫자간 간격
                }
                else if(i > 0 && i < s + 1) { // 숫자의 처음과 중간사이
                    if(target == 1 || target == 2 || target == 3 || target == 7) {
                        for(int k = 0; k < s + 2; k++) {
                            if(k == s + 1) {
                                bw.write("|");
                            } else {
                                bw.write(" ");
                            }
                        }
                    } else if(target == 5 || target == 6) {
                        for(int k = 0; k < s + 2; k++) {
                            if(k == 0) {
                                bw.write("|");
                            } else {
                                bw.write(" ");
                            }
                        }
                    } else {
                        for(int k = 0; k < s + 2; k++) {
                            if(k == 0 || k == s + 1) {
                                bw.write("|");
                            } else {
                                bw.write(" ");
                            }
                        }
                    }
                    bw.write(" "); // 숫자간 간격
                }
                else if(i == s + 1) { // 숫자의 중간
                    if(target == 0 || target == 1 || target == 7) {
                        for(int k = 0; k < s + 2; k++) {
                            bw.write(" ");
                        }
                    } else {
                        for(int k = 0; k < s + 2; k++) {
                            if(k == 0 || k == s + 1) {
                                bw.write(" ");
                            } else {
                                bw.write("-");
                            }
                        }
                    }
                    bw.write(" "); // 숫자간 간격
                }
                else if(i > s + 1 && i < (s * 2) + 2) { // 숫자의 중간과 끝 사이
                    if(target == 2) {
                        for(int k = 0; k < s + 2; k++) {
                            if(k == 0) {
                                bw.write("|");
                            } else {
                                bw.write(" ");
                            }
                        }
                    } else if(target == 1 || target == 3 || target == 4 || target == 5 || target == 7
                        || target == 9) {
                        for(int k = 0; k < s + 2; k++) {
                            if(k == s + 1) {
                                bw.write("|");
                            } else {
                                bw.write(" ");
                            }
                        }
                    } else {
                        for(int k = 0; k < s + 2; k++) {
                            if(k == 0 || k == s + 1) {
                                bw.write("|");
                            } else {
                                bw.write(" ");
                            }
                        }
                    }
                    bw.write(" "); // 숫자간 간격
                }
                else { // 숫자의 끝
                    if(target == 1 || target == 4 || target == 7) {
                        for(int k = 0; k < s + 2; k++) {
                            bw.write(" ");
                        }
                    } else {
                        for(int k = 0; k < s + 2; k++) {
                            if(k == 0 || k == s + 1) {
                                bw.write(" ");
                            } else {
                                bw.write("-");
                            }
                        }
                    }
                    bw.write(" "); // 숫자간 간격
                }
            }
            bw.write("\n");
        }



        br.close();
        bw.close();
    }
}
