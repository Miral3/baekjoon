package ex5076;

/*
문제 이름: Web Pages
알고리즘: 문자열, 파싱, 스택
자료구조: 문자열, 스택
*/

import java.io.*;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String input = br.readLine();
            Pattern tagPattern = Pattern.compile("</*[a-z]+\\s*>|<[a-z]+\\s+/+>|<a+\\s+\\S+>");
            Matcher matcher = tagPattern.matcher(input);

            if(input.equals("#")) {
                break;
            }

            Stack<String> stack = new Stack<>();
            boolean isLegal = true;
            while(matcher.find()) {
                String s = matcher.group();

                if(s.startsWith("<")) {
                    if(s.startsWith("</")) {
                        if(stack.isEmpty()) {
                            isLegal = false;
                            break;
                        }
                        if(getTagName(s).equals(getTagName(stack.pop()))) {
                            continue;
                        } else {
                            isLegal = false;
                            break;
                        }
                    } else if(s.startsWith("<br /")) {
                        continue;
                    } else {
                        stack.add(s);
                    }
                }
            }

            if(!stack.isEmpty()) {
                isLegal = false;
            }

            if(isLegal) {
                bw.write("legal\n");
            } else {
                bw.write("illegal\n");
            }

        }

        br.close();
        bw.close();
    }

    public static String getTagName(String s) {
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++) {
            if(start != 0 && end != 0) {
                break;
            }
            if(s.charAt(i) == '<') {
                start = i + 1;
            }
            if(s.charAt(i) == '>' || s.charAt(i) == ' ') {
                end = i;
            }
        }

        String result = s.substring(start, end).replaceAll("/", "");
        return result;
    }
}
