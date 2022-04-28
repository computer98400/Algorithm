package algorithm0427;

import java.util.Stack;

public class psstringzip {

    private static int solution(String string) {
        //1. 문자열을 자른 기준을 통해서 문자열을 구분한다.
        // while (a <= string.length() / 2) {
        //     for (int i = 0; i < string.length()/a; i++) {
        //         System.out.println(string.substring(i*a, (i*a)+a));
        //     }
        //     a++;
        // }
        int a = 1;

        //2
        Stack<String> test;

        StringBuilder sb;
        while (a <= string.length() / 2) {
            test = new Stack<>();
            sb = new StringBuilder();
            System.out.println(8 / 3);
            for (int i = 0; i < string.length() / a; i++) {
                if (test.isEmpty()) {
                    test.push(string.substring(i * a, (i * a) + a));
                } else {
                    // System.out.println("stack's peek : " + test.peek() + " charAt : " + string.charAt(i));
                    if (test.peek().equals(string.substring(i * a, (i * a) + a))) {
                        //같은경우에 스택에 추가해줌.
                        test.push(string.substring(i * a, (i * a) + a));
                        // System.out.println("check");
                    } else {
                        //다를 경우 현재 스택에 있는 애들을 모두 빼주고, 갯수를 파악해서 숫자 + 문자로 변경
                        // System.out.println(string.substring(i * a, (i * a) + a));
                        if (test.size() == 1) {
                            sb.append(test.peek());
                            test.clear();
                        } else {
                            sb.append(test.size()).append(test.peek());
                            test.clear();
                        }
                        test.push(string.substring(i * a, (i * a) + a));
                    }
                }
                System.out.println("i값 범위 시작 : " + (i * a)+" 끝 : "+((i*a)+a));
                
                if (((i * a) + a) >= string.length()) {
                    System.out.println("마지막 i값 추적 :" + i);
                    // System.out.println("나머지 배열 : "+string.substring(i * a).length());
                    if (test.size() == 1) {
                        sb.append(test.peek());
                    } else {
                        sb.append(string.substring(i * a));
                        // sb.append(test.size()).append(test.peek());
                    }
                }
            }
            System.out.println("결과 문자열 : "+sb.toString());
            System.out.println("결과 문자열 길이 : " + sb.toString().length());
            //최소값 비교 해서 출력

            a++;
            System.out.println("스택 남은값 확인용 "+test.size());
            
            System.out.println("=======================");
        }
        

        return 0;
    }
    public static void main(String[] args) {
        solution("aabbaccc");
        // solution("abcabcabcabcdededededede");
    }
}
