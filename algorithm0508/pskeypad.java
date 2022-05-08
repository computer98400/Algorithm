package algorithm0508;

import java.util.Arrays;

public class pskeypad {
    
    public static int[] solution(String line) {
        int[] answer = new int[line.length()];

        int[] left = { 1, 0 };
        int[] right = { 1, 9 };
        char[] numbers = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' } ;
        char[] temp = {'Q','W','E','R','T','Y','U','I','O','P'} ;



        for (int i = 0; i < line.length(); i++) {
            //문자 위치 찾기
            int[] pos = new int[2];
            if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                for (int j = 0; j < numbers.length; j++) {
                    if (numbers[j] == line.charAt(i)) {
                        pos[0] = 0;
                        pos[1] = j;
                        break;
                    }
                }
            } else {
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] == line.charAt(i)) {
                        pos[0] = 1;
                        pos[1] = j;
                        break;
                    }
                }
            }
            
            //거리 비교하기
            int leftdis = Math.abs(left[0] - pos[0]) + Math.abs(left[1] - pos[1]);
            int rightdis = Math.abs(right[0] - pos[0]) + Math.abs(right[1] - pos[1]);
            int lefthorizon = Math.abs(left[1] - pos[1]);
            int righthorizon = Math.abs(right[1] - pos[1]);
            
            System.out.println(Arrays.toString(pos));
            System.out.println("왼쪽 현재위치 : " + Arrays.toString(left));
            System.out.println("오른쪽 현재위치 : " + Arrays.toString(right));
            System.out.println("왼쪽 거리 : "+leftdis+" "+lefthorizon);
            System.out.println("오른쪽 거리 : "+rightdis+" "+righthorizon);
            // System.out.println("양쪽 거리 : "+leftdis+" "+rightdis);

            if (leftdis > rightdis) {
                right[0] = pos[0];
                right[1] = pos[1];
                answer[i] = 1;
            }else if(leftdis < rightdis){
                left[0] = pos[0];
                left[1] = pos[1];
                answer[i] = 0;
            } else {
                System.out.println("check2");
                if (lefthorizon > righthorizon) {
                    right[0] = pos[0];
                    right[1] = pos[1];
                    answer[i] = 1;
                } else if(lefthorizon < righthorizon){
                    left[0] = pos[0];
                    left[1] = pos[1];
                    answer[i] = 0;
                } else {
                    System.out.println("check3");
                    if (pos[1] < 5) {
                        left[0] = pos[0];
                        left[1] = pos[1];
                        answer[i] = 0;
                    } else {
                        right[0] = pos[0];
                        right[1] = pos[1];
                        answer[i] = 1;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(answer));


        return answer;
    }
    
    public static void main(String[] args) {
        solution("RYI76");

    }
}
