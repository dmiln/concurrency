package leetcode.may;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Dota2Senate649 {

    public static void main(String[] args) {
        Dota2Senate649 dota = new Dota2Senate649();
        System.out.println(dota.predictPartyVictoryMy("RD"));
    }

    public String predictPartyVictoryMy(String senate) {
        Map<Character, Integer> senMap = new HashMap<>();
        List<Character> senators = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            senators.add(c);
            senMap.put(c, senMap.getOrDefault(c, 0) + 1);
        }

        LinkedList<Character> stack = new LinkedList<>();
        String res = "";
        while (senators.size() > 0) {
            Character senator = senators.remove(0);
            char opposite = senator == 'R' ? 'D' : 'R';
            if (stack.isEmpty()) {
                if (senMap.get(opposite) == null || senMap.get(opposite) <= 0) {
                    res = senator == 'R' ? "Radiant" : "Dire";
                    break;
                }
                stack.addLast(opposite);
                senators.add(senator);
            } else {
                Character last = stack.getLast();
                if (last == senator) {
                    senMap.put(last, senMap.get(last) - 1);
                    stack.removeLast();
                } else {
                    if (senMap.get(opposite) == null || senMap.get(opposite) <= 0) {
                        res = senator == 'R' ? "Radiant" : "Dire";
                        break;
                    }
                    stack.addLast(opposite);
                    senators.add(senator);
                }
            }
        }

        return res;
    }

    public String predictPartyVictoryExpl(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            char senator = senate.charAt(i);
            if (senator == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            Integer rI = radiant.poll();
            Integer dI = dire.poll();
            if (rI < dI) {
                radiant.offer(rI + senate.length());
            } else {
                dire.offer(dI + senate.length());
            }
        }
        return dire.isEmpty() ? "Radiant" : "Dire";
    }
}
