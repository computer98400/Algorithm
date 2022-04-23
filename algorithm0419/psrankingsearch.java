package algorithm0419;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class psrankingsearch {
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[info.length];
        String[][] total = new String[info.length][5];

        for (int i = 0; i < info.length; i++) {
            total[i] = info[i].split(" ");
        }

        for (int i = 0; i < query.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            int trash = info.length-1;
            for (int d = 0; d < total.length; d++) {
                temp.add(0);
            }

            String[] check = new String[5];
            String[] test = query[i].split(" and ");
            for (int j = 0; j < test.length - 1; j++) {
                check[j] = test[j];
            }
            String[] show = test[3].split(" ");
            check[3] = show[0];
            check[4] = show[1];

            //조회 5 ,4, 3,2,1
            for (int q = 0; q < check.length - 1; q++) {
                if (check[q].equals("-")) {
                    trash--;
                } else {
                    for (int p = 0; p < total.length; p++) {
                        if (check[q].equals(total[p][q])) {
                            temp.set(p, temp.get(p) + 1);
                        }
                    }
                }
            }

            for (int k = 0; k < total.length; k++) {
                int score = Integer.parseInt(total[k][4]);
                // System.out.println(Integer.parseInt(check[4])+" "+score);
                if (score >= Integer.parseInt(check[4])) {
                    temp.set(k, temp.get(k) + 1);
                }
            }
            System.out.println(temp.toString()+" "+trash);
            for (int h = 0; h < temp.size(); h++) {
                if (temp.get(h) == trash) {
                    answer[i]++;
                }
            }
        }
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
    
    
    
    public static void main(String[] args) {
        solution(new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});

    }
}
