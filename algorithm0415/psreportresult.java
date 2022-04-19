package algorithm0415;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class psreportresult {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, ArrayList<String>> list = new HashMap<>();
        HashMap<String, ArrayList<String>> count = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        HashMap<String, Integer> last = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            list.put(id_list[i], new ArrayList<>());
            count.put(id_list[i], new ArrayList<>());
            result.put(id_list[i], 0);
            last.put(id_list[i], 0);
        }
        for (int i = 0; i < report.length; i++) {
            String[] temp = report[i].split(" ");
            if (list.get(temp[0]).size() != 0) {
                boolean flag = false;
                for (int j = 0; j < list.get(temp[0]).size(); j++) {
                    if (list.get(temp[0]).get(j).equals(temp[1])) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    result.put(temp[1], result.get(temp[1]) + 1);
                    count.get(temp[1]).add(temp[0]);
                    list.get(temp[0]).add(temp[1]);
                }
            } else {
                result.put(temp[1], result.get(temp[1]) + 1);
                count.get(temp[1]).add(temp[0]);
                list.get(temp[0]).add(temp[1]);
            }
        }
        System.out.println("check : "+list.keySet());
        System.out.println(list.toString());
        System.out.println(count.toString());
        System.out.println(result.toString());
        


        for (Entry<String,Integer> elem : result.entrySet()) {
            if (result.get(elem.getKey()) >= k) {
                for (int i = 0; i < count.get(elem.getKey()).size(); i++) {
                    last.put(count.get(elem.getKey()).get(i), last.get(count.get(elem.getKey()).get(i)) + 1);
                }
            }
        }
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = last.get(id_list[i]);
        }



        return answer;
    }
    public static void main(String[] args) {
        solution(new String[] { "muzi", "frodo", "apeach", "neo" }, new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
        solution(new String[] { "con", "ryan" }, new String[] {"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
    }
}
