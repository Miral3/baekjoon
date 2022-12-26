package ex20006;

/*
문제 이름: 랭킹전 대기열
알고리즘: 구현, 시뮬레이션
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Player implements Comparable<Player> {
    int level;
    String name;

    public Player(int level, String name) {
        this.level = level;
        this.name = name;
    }

    @Override
    public int compareTo(Player p) {
        return name.compareTo(p.name);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int p = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        ArrayList<ArrayList<Player>> list = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            input = br.readLine().split(" ");
            int level = Integer.parseInt(input[0]);
            String name = input[1];
            boolean isParticipated = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).size() == m) {
                    continue;
                }
                int firstPlayerLevel = list.get(j).get(0).level;
                if (firstPlayerLevel + 10 >= level && firstPlayerLevel - 10 <= level) {
                    ArrayList<Player> next = list.get(j);
                    next.add(new Player(level, name));
                    isParticipated = true;
                    break;
                }
            }
            if (!isParticipated) {
                ArrayList<Player> next = new ArrayList<>();
                next.add(new Player(level, name));
                list.add(next);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            ArrayList cur = list.get(i);
            int size = cur.size();
            if (size == m) {
                bw.write("Started!\n");
            } else {
                bw.write("Waiting!\n");
            }
            Collections.sort(cur);
            for (int j = 0; j < size; j++) {
                Player player = list.get(i).get(j);
                int level = player.level;
                String name = player.name;
                bw.write(level + " " + name + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
