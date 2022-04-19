package algorithm0419;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class psrankingsearch {
    public static int[] solution(String[] info, String[] query) {
        int[] answer = {};
        String[][] total = new String[info.length][5];

        for (int i = 0; i < info.length; i++) {
            total[i] = info[i].split(" ");
            System.out.println(Arrays.toString(total[i]));
        }

        for (int i = 0; i < query.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            String[] test = query[i].split("and");
            for (int q = 0; q < test.length; q++) {
                test[q] = test[q].trim();
            }

            System.out.println(Arrays.toString(test));

            

            for (int j = 0; j < test.length; j++) {
                if (test[j].contains("-")) {
                    for (int p = 0; p < info.length; p++) {
                        temp.add(p);
                    }
                } else {
                    for (int k = 0; k < total.length; k++) {
                        if (total[k][j].contains(test[j])) {
                            temp.add(k);
                        }
                    }
                }
            }
            Collections.sort(temp);
            System.out.println(temp.toString());

        }


        return answer;
    }
    
    
    
    public static void main(String[] args) {
        solution(new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});

    }
}
