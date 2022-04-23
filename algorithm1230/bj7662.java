package algorithm1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj7662 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int Tc = Integer.parseInt(br.readLine());


        for (int i = 0; i < Tc; i++) {
            
            int numbers = Integer.parseInt(br.readLine());
            PriorityQueue<Long> que = new PriorityQueue<>();
            PriorityQueue<Long> querevers = new PriorityQueue<>(Collections.reverseOrder());
            int count =0;
            boolean flag = false;
            for (int j = 0; j < numbers; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                String order = st.nextToken();
                Long number  = Long.parseLong(st.nextToken());
                if(order.equals("I")){
                    que.offer(number);
                    querevers.offer(number);
                    count++;
                }else if(order.equals("D")){
                    if(count <= 0){
                        continue;
                    }else{
                        if(number == -1){
                            que.poll();
                            count--;
                            flag = false;
                        }else if(number == 1){
                            querevers.poll();
                            count--;
                            flag = true;
                        }
                    }
                }
            }

            if(count == 0) {
            
                System.out.println("EMPTY");
            
            } else if(count == 1) {
            
                if(que.size()== 1){
            
                    Long temp = que.poll();
            
                    System.out.println(temp+" "+temp);
            
                    continue;
                } else {
                    Long temp = querevers.poll();
            
                    System.out.println(temp+" "+temp);
            
                }
            } else {
            
                System.out.println(querevers.poll()+" "+que.poll());
            
            }

        }
    }   
}
