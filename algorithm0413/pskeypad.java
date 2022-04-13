package algorithm0413;

public class pskeypad {


    public static String solution(int[] numbers, String hand) {
        String answer = "";
        boolean flag = false;
        if (hand.equals("left")) {
            flag = true;
        }
        int[] leftFinger = {3,0};
        int[] rightFinger = {3,2};

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1){
                leftFinger[0] = 0;
                leftFinger[1] = 0;
                answer += "L";
            }else if(numbers[i] == 4 ){
                leftFinger[0] = 1;
                leftFinger[1] = 0;
                answer += "L";
            }else if(numbers[i] == 7) {                
                leftFinger[0] = 2;
                leftFinger[1] = 0;
                answer += "L";
            } else if (numbers[i] == 3){
                rightFinger[0] = 0;
                rightFinger[1] = 2;
                answer += "R";
            }else if (numbers[i] == 6){
                rightFinger[0] = 1;
                rightFinger[1] = 2;
                answer += "R";               
            }else if(numbers[i] == 9) {
                rightFinger[0] = 2;
                rightFinger[1] = 2;
                answer += "R";
            } else {
                int[] temp = new int[2];
                if (numbers[i] == 0) {
                    temp[0] = 3;
                    temp[1] = 1;
                } else {
                    temp[0] = (numbers[i]-1)/3;
                    temp[1] = (numbers[i]-1)%3;
                }
                if (Math.abs(leftFinger[0] - temp[0]) + Math.abs(leftFinger[1] - temp[1]) == Math.abs(rightFinger[0] - temp[0]) + Math.abs(rightFinger[1] - temp[1])) {
                    if(flag){
                        leftFinger[0] = temp[0];
                        leftFinger[1] = temp[1];
                        answer += "L";
                    }else{
                        rightFinger[0] = temp[0];
                        rightFinger[1] = temp[1];
                        answer += "R";
                    }
                }else if(Math.abs(leftFinger[0] - temp[0]) + Math.abs(leftFinger[1] - temp[1]) > Math.abs(rightFinger[0] - temp[0]) + Math.abs(rightFinger[1] - temp[1])){
                    rightFinger[0] = temp[0];
                    rightFinger[1] = temp[1];
                    answer += "R";
                } else {
                    leftFinger[0] = temp[0];
                    leftFinger[1] = temp[1];
                    answer += "L";
                }
                
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
        
        solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right");
        solution(new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 }, "left");
        solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, "right");

    }
}
