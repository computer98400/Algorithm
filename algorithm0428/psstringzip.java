package algorithm0428;

public class psstringzip {
    

    public static int solution(String s) {
        int a = 1;
        int answer = 1001;
        if (s.length() == 1) {
            return 1;
        }
        while (a <= s.length() / 2) {

            StringBuilder sb = new StringBuilder();
            String pre = "";
            int count = 1;
            for (int i = 0; i < s.length() / a + 1; i++) {
                // System.out.println("a : "+a+" i : "+i+" "+(i * a + a));
                String temp = "";
                if ((i * a + a) > s.length()) {
                    //마지막 값일 때
                    temp = s.substring(i * a);
                } else {
                    //처음부터 마지막 전까지
                    temp = s.substring(i * a, i * a + a);
                }

                //            System.out.println(" temp :  "+(i*a)+" " + temp + " pre : "+pre);
                if (pre.equals("")) {
                    pre = temp;
                } else {
                    if (pre.equals(temp)) {
                        count++;
                    } else {
                        if (count == 1) {
                            sb.append(pre);
                            pre = temp;
                        } else {
                            sb.append(count).append(pre);
                            count = 1;
                            pre = temp;
                        }
                    }
                }

                if (temp.length() != a) {
                    sb.append(temp);
                }
            }
            // System.out.println(sb.length());
            answer = Math.min(sb.length(), answer);
            a++;
        }
        
        return answer;
    }
    
    
    public static void main(String[] args) {
        
        solution("aabbaccc");
        solution("ababcdcdababcdcd");
        solution("abcabcdede");
        solution("abcabcabcabcdededededede");
        solution("xababcdcdababcdcd");
    }
}
