package algorithm0415;

public class psnewid {
    public static String solution(String new_id) {
        String answer = "";
        answer = step1(new_id);
        // System.out.println("step1 : " + answer);
        answer = step2(answer);
        // System.out.println("step2 : " + answer);
        answer = step3(answer);
        // System.out.println("step3 : " + answer);
        answer = step4(answer);
        // System.out.println("step4 : " + answer);
        answer = step5(answer);
        // System.out.println("step5 : " + answer);
        answer = step6(answer);
        // System.out.println("step6 : " + answer);
        answer = step7(answer);
        // System.out.println(answer);
        return answer;
    }

    public static String step1(String pre) {
        return pre.toLowerCase();
    }

    public static String step2(String new_id) {
        String temp ="";
        for (int i = 0; i < new_id.length(); i++) {
            if (new_id.charAt(i) == '.' || new_id.charAt(i) == '_' || new_id.charAt(i) == '-'
                    || (new_id.charAt(i) >= 'a' && new_id.charAt(i) <= 'z') || (new_id.charAt(i) >= '0' && new_id.charAt(i) <= '9')) {
                temp += new_id.charAt(i);
            }
        }

        return temp;
    }

    public static String step3(String pre) {
        while (pre.contains("..")) {
            pre = pre.replace("..", ".");
        }
        
        return pre;
    }

    public static String step4(String pre) {
            
        if (pre.charAt(0) == '.') {
            pre = pre.substring(1);
        }
        if (pre.length() != 0) {
            
            if (pre.charAt(pre.length()-1) == '.') {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }
    public static String step5(String pre) {
        if (pre.length() == 0) {
            pre = "a";
        }
        return pre;
    }

    public static String step6(String pre) {
        
        if (pre.length() >= 15) {
            pre = pre.substring(0, 15);
        }
        if (pre.charAt(pre.length() - 1) == '.') {
            pre = pre.substring(0, pre.length()-1);
        }
        return pre;
    }
    public static String step7(String pre) {
        if (pre.length() <= 2) {
            char temp = pre.charAt(pre.length() - 1);
            while (pre.length() != 3) {
                pre += ""+temp;
            }
        }
        return pre;
    }

    public static void main(String args[]) {
        solution("...!@BaT#*..y.abcdefghijklm");
        solution("z-+.^.");
        solution("=.=");
        solution("123_.def");
        solution("abcdefghijklmn.p");
    }

}
