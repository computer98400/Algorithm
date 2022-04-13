package algorithm0412;

public class psnewid {
    public static String solution(String new_id) {

        //1
        new_id = new_id.toLowerCase();
        String temp = "";
        //2
        for (int i = 0; i < new_id.length(); i++) {
            if (new_id.charAt(i) == '.' || new_id.charAt(i) == '_' || new_id.charAt(i) == '-'
                    || (new_id.charAt(i) >= 'a' && new_id.charAt(i) <= 'z')) {
                temp += new_id.charAt(i);
            }
        }
        new_id = temp;
        temp = "";
        //3
        for (int i = 0; i < new_id.length(); i++) {
            if (new_id.charAt(i) == '.') {
                while (true) {
                    if (i == new_id.length() - 1 || new_id.charAt(i) != '.') {
                        break;
                    } else {
                        i++;
                    }
                }
                temp += '.';
            } else {
                i--;
                temp += new_id.charAt(i);
            }
        }


        return temp;
    }



    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
    }
}
