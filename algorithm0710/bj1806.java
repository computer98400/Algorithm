import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i< numbers.length;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int start =0;
        int end =0;
        int hap = 0;
        int leng = 100001;
        if(hap > S){
            System.out.println(1);
            return;
        }
        while(start < N && end >= start){


            if(hap >= S){
                if(leng > end-start){
                    leng = end - start ;
                }
                hap -= numbers[start];
                start++;

                continue;
            }
            if(end == numbers.length){
                start++;
                continue;
            }
            if(end < N){
                hap+= numbers[end];
                end++;
            }
        }
        if(leng == 100001){
            System.out.println(0);
        }else{
            System.out.println(leng);
        }
    }

}
