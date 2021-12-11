package algorithm1125;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj5430 {
    public static void main(String[] args) throws Exception{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int Tc = Integer.parseInt(sc.readLine());
        test : for (int i = 0; i < Tc; i++) {
            String command = sc.readLine();
            int front = 0;
            int back = Integer.parseInt(sc.readLine()) - 1;
            int count = 0;
            boolean flag = false;
            String temp = sc.readLine();
            for (int j = 0; j < command.length(); j++) {
                if (command.charAt(j) == 'D') {
                    count++;
                }
                if (count > back) {
                    System.out.println("error");
                    continue test;
                }
            }
            temp = temp.substring(1, temp.length() - 1);
            String[] numbers = temp.split(",");
            back = numbers.length - 1;
            
            for (int j = 0; j < command.length(); j++) {
                if (command.charAt(j) == 'R') {
                    flag = !flag;
                } else if (command.charAt(j) == 'D') {
                    if (flag)
                        back--;
                    else
                        front++;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (flag) {
                for (int j = back; j >= front; j--) {
                    sb.append(numbers[j] + ",");
                }
            } else {
                for (int j = front; j <= back; j++) {
                    sb.append(numbers[j] + ",");
                }
            }
            if (sb.length() > 1) {
                sb.setLength(sb.length()-1);
            }
            sb.append("]");
            System.out.println(sb.toString());
        }


    }
}
