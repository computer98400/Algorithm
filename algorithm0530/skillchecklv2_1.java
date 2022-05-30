package algorithm0530;

import java.util.Arrays;

public class skillchecklv2_1 {
    public static int solution(int[][] land) {
        int answer = 0;
        int[][] answermap = new int[land.length+1][4];

        for (int i = 1; i < answermap.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    answermap[i][j] = land[i-1][j]+ Math.max(Math.max(answermap[i - 1][1],answermap[i - 1][2]),answermap[i-1][3]);
                } else if (j == 1) {
                    answermap[i][j] = land[i-1][j] + Math.max(Math.max(answermap[i - 1][0],answermap[i - 1][2]),answermap[i-1][3]);
                } else if (j == 2) {
                    answermap[i][j] = land[i-1][j] + Math.max(Math.max(answermap[i - 1][0],answermap[i - 1][1]),answermap[i-1][3]);
                } else {
                    answermap[i][j] = land[i-1][j] + Math.max(Math.max(answermap[i - 1][1],answermap[i - 1][2]),answermap[i-1][0]);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, answermap[answermap.length - 1][i]);
        } 

        return answer;
    }
    public static void main(String[] args) {
        solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}});
    }
}
