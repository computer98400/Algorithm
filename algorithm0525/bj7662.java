package Algorithm.algorithm0525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class bj7662 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i< N; i++){
            int inputcount = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> all = new HashMap<>();
            PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
            
            PriorityQueue<Integer> que2 = new PriorityQueue<>();
            for(int j=0;j< inputcount;j++){
                String[] input = br.readLine().split(" ");
                if(input[0].equals("I")){
                    all.put(Integer.parseInt(input[1]),j);
                    que.offer(Integer.parseInt(input[1]));
                    que2.offer(Integer.parseInt(input[1]));
                }else {
                    if(all.isEmpty()){
                        continue;
                    }
                    if(input[1].equals("1")){
                        int temp = que.poll();
                        if(all.containsKey(temp)){
                            all.remove(temp);
                        }
                    }
                    if(input[1].equals("-1")){
                        int temp = que2.poll();
                        if(all.containsKey(temp)){
                            all.remove(temp);
                        }
                    }
                }
            }
            if(all.isEmpty()){
                System.out.println("EMPTY");
            }else{
                System.out.println(all.get(all.size()-1)+" "+all.get(0));
            }
        }
    }
}
