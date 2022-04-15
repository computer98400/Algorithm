package algorithm0415;

public class psnumberstring {

    public static int solution(String s) {
        int answer = 0;
        String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        String s2 = s;
        for (int i = 0; i < numbers.length; i++) {
            while (true) {
                if (s2.contains(numbers[i])) {
                    if ((s2.indexOf(numbers[i])) + numbers[i].length() <= s2.length() - 1) {
                        if (s2.indexOf(numbers[i]) == 0) {
                            //앞에 숫자 붙이고 이후 문자열 가져와서 붙이고
                            s2 = i + s2.substring(s2.indexOf(numbers[i])+numbers[i].length());
                        } else {
                            s2 = s2.substring(0, s2.indexOf(numbers[i])) + i
                            + s2.substring(s2.indexOf(numbers[i]) + numbers[i].length(), s2.length());
                        }
                    } else {
                        //마지막에 있을 때 
                        s2 = s2.substring(0, s2.indexOf(numbers[i])) + i;
                    }
                } else {
                    break;
                }
            }
        }
        answer = Integer.parseInt(s2);
        return answer;
    }


    
    
    public static void main(String[] args) {
        solution("one4seveneightone");

    }
}
