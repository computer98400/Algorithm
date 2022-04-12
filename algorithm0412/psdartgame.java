package algorithm0412;

import java.util.ArrayList;

public class psdartgame {
    

    public static int solution(String dartResult) {
        int result = 0;
        char[] temp = dartResult.toCharArray();
        ArrayList<Integer> arr = new ArrayList<>();
        int idx = -1;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] >= '0' && temp[i] <= '9') {
                idx++;
                if (temp[i] == '1') {
                    if (temp[i + 1] == '0') {
                        arr.add(10);
                        i++;
                    } else {
                        arr.add(temp[i] - '0');
                    }
                } else {
                    arr.add(temp[i] - '0');
                }
            } else {
                if (temp[i] == 'S') {
                    arr.set(idx, (int)Math.pow(arr.get(idx),1));
                } else if (temp[i] == 'D') {
                    arr.set(idx, (int)Math.pow(arr.get(idx),2));
                } else if (temp[i] == 'T') {
                    arr.set(idx, (int)Math.pow(arr.get(idx),3));
                } else if (temp[i] == '*') {
                    if(idx != 0){
                        arr.set(idx - 1, arr.get(idx - 1) * 2);
                        arr.set(idx, arr.get(idx) * 2);
                    } else {
                        arr.set(idx, arr.get(idx) * 2);
                    }
                } else if (temp[i] == '#') {
                    arr.set(idx, arr.get(idx) * -1);
                }
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            result += arr.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        solution("1S2D*3T");
        solution("1D2S#10S");
        solution("1D2S0T");
        solution("1S*2T*3S");
        solution("1D#2S*3S");
        solution("1T2D3D#");
        solution("1D2S3T*");

    }

}