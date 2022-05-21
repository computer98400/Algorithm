package Algorithm.algorithm0521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13335 {
    
    
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Queue<Integer> input = new LinkedList<>();

        st = new StringTokenizer(br.readLine()," ");

        for(int i =0; i< n; i++){
            input.add(Integer.parseInt(st.nextToken()));
        }
        Queue<Integer> test = new LinkedList<>();
        
        for(int i =0; i<w; i++){
            test.add(0);
        }
        //0이 들어와야하는지, 다음 트럭이 들어와야하는지.

        //if 큐의 모든 값을 더한 것에 다음 수를 더햇을 때

        //if 건널 다음 트럭이 없을 때 끝 -> test값만 바꿔주면 됨.
        int count = 0;
        while(!input.isEmpty()){
            int total = 0;
            for (Integer integer : test) {
                total+= integer;
            }
            int nextinput = input.peek();
            int output = test.poll();

            if(total-output+nextinput <= L){
                test.add(input.poll());
            }else{
                test.add(0);
            }
            count++;
        }
        System.out.println(count+test.size());

    }
}
