package Algorithm.algorithm1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj10815 {
    public static int[] cards;


    public static int half(int searchN){
        int right = cards.length-1;
        int left = 0;

        int mid =0;
        while(left <= right){
            mid = (right+left)/2;
            if(cards[mid] == searchN){
                return 1;
            }

            if(cards[mid] < searchN){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return 0;
    }



    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
    //    System.out.println(Arrays.toString(cards));

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(half(Integer.parseInt(st.nextToken()))+" ");
        }
        System.out.println(sb);
    }
}
