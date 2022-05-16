package algorithm0516;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGSprinter {
    public static int solution(int[] priorities, int location) {
        int[] answer = new int[priorities.length];
        
        Queue<int[]> que = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            que.offer(new int[] { priorities[i], i });
        }
        int count = 0;
        while (true) {
            int[] temp = que.poll();
            count++;
            boolean flag = false;
            for (int[] temp2 : que) {
                if (temp[0] < temp2[0]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                count--;
                que.offer(temp);
            } else {
                if (temp[1] == location) {
                    break;
                }
            }
                
            
            
            // for (int[] temp3 : que) {
            //     System.out.println(Arrays.toString(temp3));
            // }
        }






        
        
        return count;
    }
    
    
    public static void main(String[] args) {
        solution(new int[] { 2, 1, 3, 2 }, 2);
        solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0);

    }
}
