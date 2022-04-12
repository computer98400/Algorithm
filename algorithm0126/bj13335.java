package algorithm0126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13335 {

    public static void truckTest() {
        if (bridge[bridge.length - 1] == 0) {
      
        }
    }

    public static int hap() {
        int temp = 0;
        for (int i = 0; i < bridge.length; i++) {
            temp += bridge[i];
        }
        return temp;
    }


    public static boolean canInput() {
        //다리 마지막 자리가 0일때
        if (bridge[bridge.length - 1] == 0) {
            //다리위의 총합이 하중을 넘지 않을때.
            if(hap()+trucks[checking] > W){

            }
            return true;
        } else {
            return false;   
        }

    }
    

    public static int checking = 0;
    public static int L;
    public static int[] trucks;
    public static int W;
    public static int[] bridge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        bridge = new int[W];
        trucks = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < trucks.length; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        //1턴이 지날때 트럭은 하나씩 내려옴.== 이동함 == 시작점.
        // but 다리위의 트럭들의 합이 하중을 넘는다면 트럭의 추가가 안됨.
        //트럭의 합이 가능한지 확인하는 true/false값.
        // 트럭의 좌표가 다리의 마지막이라면 넘어가게된다.
        //턴마다 트럭이 움직이는 메소드 1.
        //움직일때마다 트럭을 올리는 + 내리는 메소드 2.
        //움직일때마다 총합을 확인하는 메소드 3.

    }
}
