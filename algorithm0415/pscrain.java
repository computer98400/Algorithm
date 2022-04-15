package algorithm0415;

import java.util.ArrayList;
import java.util.Stack;

public class pscrain {
    
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        ArrayList<Stack<Integer>> test = new ArrayList<>();
        Stack<Integer> solution = new Stack<>();

        for (int i = 0; i < board.length; i++) {
            test.add(new Stack<>());
        }


        for (int x = 0; x < board.length; x++) {
            for (int y = board.length-1; y > -1; y--) {
                if (board[y][x] != 0) {
                    test.get(x).push(board[y][x]);
                }
            }
        }

        for (int i = 0; i < moves.length; i++) {
            // for (int j = 0; j < test.size(); j++) {
            //     System.out.println(test.get(j).toString());
            // }
            // System.out.println();
            if (!test.get(moves[i] - 1).isEmpty()) {
                int temp = test.get(moves[i] - 1).pop();
                if (!solution.isEmpty()) {
                    if (solution.peek() == temp) {
                        solution.pop();
                        answer+= 2;
                    } else {
                        solution.push(temp);
                    }
                } else {
                    solution.push(temp);
                }                
            } else {
                continue;
            }

        }
        // System.out.println(answer);
    
        return answer;
    }
    
    
    
    public static void main(String[] args) {
        solution(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 } }, new int[] { 1, 5, 3, 5, 1, 2, 1, 4 });

    }
}