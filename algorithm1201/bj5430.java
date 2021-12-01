package Algorithm.algorithm1201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class bj5430 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            int Tc = Integer.parseInt(br.readLine());

            for (int i = 0; i < Tc; i++) {
                
                String orders = br.readLine();
                int front = 0;
                int back = 0;

                int n = Integer.parseInt(br.readLine());
                String numbers = br.readLine();
                
                if(n==0){
                    if(orders.contains("D")){
                        System.out.println("error");
                        continue;
                    }
                    System.out.println("[]");
                    continue;
                }else{
                    numbers = numbers.substring(1,numbers.length()-1);
                    String[] numberst = numbers.split(",");
                    int[] numbersT = new int[n];
                    boolean start = false;
                    back = n;
                    for (int j = 0; j < n; j++) {
                        numbersT[j] = Integer.parseInt(numberst[j]);
                    } 
                    for (int j = 0; j < orders.length(); j++) {
                        if(orders.charAt(j) == 'R'){
                            start = !start;
                        }
                        if(start && orders.charAt(j) == 'D'){
                            back--;
                        }
                        if(!start && orders.charAt(j) == 'D'){
                            front++;
                        }
                    }

                    if(front > back){
                        System.out.println("error");
                        continue;
                    }

                    StringBuilder sb = new StringBuilder();
                    int count = 0;
                    sb.append("[");
                    if(start == true){
                        for (int k = back-1; k >= front; k--) {
                            sb.append(numbersT[k]+",");
                            count++;
                        }
                       
                    }else{
                        for (int j = front; j < back; j++) {
                           sb.append(numbersT[j]+",");
                           count++;
                        }
                    }
                    if(count != 0){
                        sb.setLength(sb.length()-1);
                    }
                    sb.append("]");
                    System.out.println(sb.toString());
                }

            }
    }
    



}