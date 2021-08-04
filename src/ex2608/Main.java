package ex2608;

/*
문제 이름: 로마 숫자
알고리즘: 수학, 구현, 문자열
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String romanNum1 = br.readLine();
        String romanNum2 = br.readLine();
        int sum = 0;

        sum = transformRomanNum(romanNum1) + transformRomanNum(romanNum2);

        System.out.println(sum);
        System.out.println(transfromArabicNum(sum));

        br.close();
        bw.close();
    }

    public static int transformRomanNum(String num) {
        int len = num.length();
        int sum = 0;

        for(int i = 0; i < len; i++) {
            if(num.charAt(i) == 'M') {
                sum += 1000;
            }
            else if(num.charAt(i) == 'D') {
                sum += 500;
            }
            else if(num.charAt(i) == 'C') {
                if(i < len - 1) {
                    if (num.charAt(i + 1) == 'M') {
                        sum += 900;
                        i++;
                    }
                    else if (num.charAt(i + 1) == 'D') {
                        sum += 400;
                        i++;
                    }
                    else {
                        sum += 100;
                    }
                }
                else {
                    sum += 100;
                }
            }
            else if(num.charAt(i) == 'L') {
                sum += 50;
            }
            else if(num.charAt(i) == 'X') {
                if(i < len - 1) {
                    if (num.charAt(i + 1) == 'C') {
                        sum += 90;
                        i++;
                    }
                    else if (num.charAt(i + 1) == 'L') {
                        sum += 40;
                        i++;
                    }
                    else {
                        sum += 10;
                    }
                }
                else {
                    sum += 10;
                }
            }
            else if(num.charAt(i) == 'V') {
                sum += 5;
            }
            else if(num.charAt(i) == 'I') {
                if(i < len - 1) {
                    if (num.charAt(i + 1) == 'X') {
                        sum += 9;
                        i++;
                    }
                    else if (num.charAt(i + 1) == 'V') {
                        sum += 4;
                        i++;
                    }
                    else {
                        sum += 1;
                    }
                }
                else {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public static String transfromArabicNum(int num) {
        String romanNum = "";
        boolean isUsed = false;

        while(num > 0) {
            if(num >= 1000) {
                num -= 1000;
                romanNum += "M";
            }
            else if(!isUsed && num >= 900) {
                num -= 900;
                romanNum += "CM";
            }
            else if(num >= 500) {
                num -= 500;
                romanNum += "D";
            }
            else if(!isUsed && num >= 400) {
                num -= 400;
                romanNum += "CD";
            }
            else if(num >= 100) {
                num -= 100;
                romanNum += "C";
            }
            else if(!isUsed && num >= 90) {
                num -= 90;
                romanNum += "XC";
            }
            else if(num >= 50) {
                num -= 50;
                romanNum += "L";
            }
            else if(!isUsed && num >= 40) {
                num -= 40;
                romanNum += "XL";
            }
            else if(num >= 10) {
                num -= 10;
                romanNum += "X";
            }
            else if(!isUsed && num >= 9) {
                num -= 9;
                romanNum += "IX";
            }
            else if(num >= 5) {
                num -= 5;
                romanNum += "V";
            }
            else if(!isUsed && num >= 4) {
                num -= 4;
                romanNum += "IV";
            }
            else if(num >= 1) {
                num -= 1;
                romanNum += "I";
            }
        }

        return romanNum;
    }
}
