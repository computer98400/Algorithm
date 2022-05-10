package algorithm0508;

public class psmask {
    
    public static int solution(int[][] atmos) {
        int answer = 0;
        //마스크를 썼는가 안쓰는가
        boolean flag = false;
        //+2일까지 사용하는가 안하는가
        int daycount = 0;

        for (int i = 0; i < atmos.length; i++) {

            if (atmos[i][0] >= 151 && atmos[i][1] >= 76) {
                flag = false;
                answer++;
                daycount = 0;
                continue;
            }
            
            if (daycount == 2) {
                answer++;
                daycount = 0;
                flag = false;
                continue;
            }
            //둘중 하나가 나쁨일시에
            if (atmos[i][0] >= 81 || atmos[i][1] >= 36) {
                if (!flag) {
                    flag = true;
                }
            }
            if (flag) {
                daycount++;
            }
        }
        if (flag) {
            answer++;
        }
        return answer;
    }
    
    public static void main(String[] args) {
        
        solution(new int[][] {{140, 90}, {177, 75}, {95, 45}, {71, 31}, {150, 30}, {80, 35}, {72, 33}, {166, 81}, {151, 75}});
        solution(new int[][] { {80, 35}, {70, 38}, {100, 41}, {75,30}, {160,80}, {77, 29}, {181, 68}, {151, 76} });
        solution(new int[][] { {30, 15}, {80, 35} });
    }
}
