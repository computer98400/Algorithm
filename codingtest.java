import java.util.Arrays;

public class codingtest {
    
    public static int solution(int[] D, String[] T) {
        
        int[] hReach = new int[D.length+1];
        int[][] trashs = new int[T.length][3];
        boolean[] pcheck = new boolean[T.length];
        boolean[] gcheck = new boolean[T.length];
        boolean[] mcheck = new boolean[T.length];

        for (int i = T.length - 1; i > 0; i--) {
        
            for (int j = 0; j < T[i].length(); j++) {

                if (T[i].charAt(j) == 'P') {
        
                    pcheck[i] = true;

                } else if (T[i].charAt(j) == 'G') {

                    gcheck[i] = true;

                } else {

                    mcheck[i] = true;

                }

            }
        
        }
        
        //[현재 수거하는 집]-[수거를 한 이전집까지의 거리] +1;

        //+[마지막 수거한 집의 거리]

        // 1시간
        
        //1,2
        //1번 = 어떤 스트링이 들어왔을때 첫번째 값이 대문자, 소문자, 숫자, other 출력
        //아스키코드값 찾아서 해당 범위인지 확인.

        //2번 N[1,1,2,3,4,5,3,3],5
        //false;
        //1~5까지의 값이 N에 있어야되기때문.

        // 1~K까지의 값이 N에 포함 되어있으면 true
        // 1~K까지의 값이 N에 포함 안 되어있으면 false

        // boolean[300000] N에 있는 값을 체크해주고
        // 1~K까지 boolean[]탐색해서 중간에 false가 잇으면 false
        // 끝까지 없으면 true;
        // 예시 입력이 있어서 -> 이걸 고쳐서 출력하는가
        // 내가 내 맘대로 코드 짜서 만드는가

        


        for (int i = 1; i <= D.length; i++) {
            hReach[i] = hReach[i - 1] + D[i-1];
        }

        int p = 0;
        int prep = 0;   //이전값 위치.
        int ppos = 0;
        int g = 0;
        int grep = 0;
        int gpos = 0;
        int m = 0;
        int mrep = 0;
        int mpos = 0;
        for (int i = 0; i < pcheck.length; i++) {
            if (pcheck[i]) {
                if (p == 0) {
                    p = hReach[i+1] + 1;
                    ppos = Math.max(i, ppos);
                    prep = ppos;
                } else {
                    ppos = Math.max(i, ppos);
                    p = hReach[i+1]-hReach[prep] + 1;
                    prep = ppos;
                }
            }
            if (gcheck[i]) {
                if (g == 0) {
                    g = hReach[i+1] + 1;
                    gpos = Math.max(i, gpos);
                    grep = gpos;
                } else {
                    gpos = Math.max(i, gpos);
                    g = hReach[i+1]-hReach[grep] + 1;
                    grep = gpos;
                }
            }
            if (mcheck[i]) {
                if (m == 0) {
                    m = hReach[i+1] + 1;
                    mpos = Math.max(i, mpos);
                    mrep = gpos;
                } else {
                    mpos = Math.max(i, mpos);
                    m = hReach[i+1] - hReach[mrep] + 1;
                    mrep = mpos;
                }
            }
            System.out.println(ppos +" "+prep);
        }
        p += hReach[ppos];
        g += hReach[gpos];
        m += hReach[mpos];
        // System.out.println(Arrays.toString(pcheck));
        // System.out.println(Arrays.toString(gcheck));
        // System.out.println(Arrays.toString(mcheck));
        // System.out.println(Arrays.toString(hReach));
       // System.out.println(Math.max(Math.max(p, g), m));
        return Math.max(Math.max(p, g), m);
    }
    
    
    public static void main(String[] args) {
        solution(new int[] { 3, 2, 4 }, new String[] { "MPM", "", "G" });
        

        // 쓰레기 재활용 트럭
        // P G M 플라스틱 글라스 메탈
        //[각 집까지 가는 잇는 거리]

        //[3,2,4]
        //[mpm, , g]

        //3+2+4   쓰레기 수거시간 1
        //3+2+4+1+4+2+3; == 출력값
        //[집에 버린 쓰레기]
        //구간 합 문제.
        
        //매 경우에서의 구간이 1차원배열로 표현하는거.
        
        //2~5까지의 합 O(1)

        //출력값은 3개의 트럭이 쓰레기를 모두 가져오는 시간.

    }
}
