package algorithm0508;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ps2 {
    public static String[] solution(String[] rooms, int target) {
        
        String[] answer = {};
        int[] roomnum = new int[rooms.length];
        ArrayList<String[]> person = new ArrayList<>();
        //일단 사람 모두 가져온 다음 각 자리에 대해서 없는 사람 체크, 해당 우선순위 대문자, 소문자,
        //이후 각 사람이 방을 몇개 가지는지 체크
        boolean flag = false;

        HashMap<String, HashSet<Integer>> solution = new HashMap<>();
        int check =-1;
        for (int i = 0; i < rooms.length; i++) {
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            for (int j = 0; j < rooms[i].length(); j++) {
                if (rooms[i].charAt(j) == '[') {
                    flag = true;
                    continue;
                }
                if (rooms[i].charAt(j) == ']') {
                    flag = false;
                    idx = j + 1;
                    break;
                }
                if (flag) {
                    sb.append(rooms[i].charAt(j));
                }
            }
            roomnum[i] = Integer.parseInt(sb.toString());

            if (roomnum[i] == target) {
                check = i;
            }
            person.add(rooms[i].substring(idx).split(","));

            //사람이 어느 방에 있는지 다 확인함. ex) andy, 101,403,404
            //target 방에 있는 경우 사람 제외

            for (int q = 0; q < person.size(); q++) {
                if (target == roomnum[q]) {
                    continue;
                } else {
                    for (int w = 0; w < person.get(q).length; w++) {
                        if (solution.containsKey(person.get(q)[w])) {
                            HashSet<Integer> temp4 = solution.get(person.get(q)[w]);
                            temp4.add(roomnum[q]);
                            solution.put(person.get(q)[w], temp4);
                        } else {
                            HashSet<Integer> temp3 = new HashSet<>();
                            temp3.add(roomnum[q]);
                            solution.put(person.get(q)[w], temp3);
                        }
                    }
                }
            }
        }
        //방을 가진 갯수별로 사람 순서로 정렬
        System.out.println(solution);
        return answer;
    }


    public static void main(String[] args) {
        solution(new String[]{"[403]James", "[404]Azad,Louis,Andy", "[101]Azad,Guard"},403);
    }
}