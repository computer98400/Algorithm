package javaOverride;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class compareTest {

    static class shark{
        int Y;
        int X;
        int time;

        shark(int Y, int X, int time){
            this.Y = Y;
            this.X = X;
            this.time = time;
        }
        
        @Override
        public String toString() {
            return "shark [X=" + X + ", Y=" + Y + ", time=" + time + "]";
        }

    }


    public static void main(String[] args) {

        int[][] test = new int[10][3];
        
        ArrayList<shark> sharkTest = new ArrayList<>();

        sharkTest.add(new shark(1,2,1));
        sharkTest.add(new shark(1,2,3));
        sharkTest.add(new shark(1,2,2));
        sharkTest.add(new shark(1,3,3));
        sharkTest.add(new shark(1,3,2));
        sharkTest.add(new shark(1,3,3));
        sharkTest.add(new shark(1,1,1));
        sharkTest.add(new shark(1,1,1));
        sharkTest.add(new shark(2,1,1));
        sharkTest.add(new shark(2,2,1));

        test[0][0] = 1;
        test[0][1] = 2;
        test[0][2] = 1;

        test[1][0] = 1;
        test[1][1] = 2;
        test[1][2] = 3;
        
        test[2][0] = 1;
        test[2][1] = 2;
        test[2][2] = 2;
        
        test[3][0] = 1;
        test[3][1] = 3;
        test[3][2] = 3;
        
        test[4][0] = 1;
        test[4][1] = 3;
        test[4][2] = 2;
        
        test[5][0] = 1;
        test[5][1] = 3;
        test[5][2] = 3;
        
        test[6][0] = 1;
        test[6][1] = 1;
        test[6][2] = 1;
        
        test[7][0] = 1;
        test[7][1] = 1;
        test[7][2] = 1;

        test[8][0] = 2;
        test[8][1] = 1;
        test[8][2] = 1;
        
        test[9][0] = 2;
        test[9][1] = 2;
        test[9][2] = 1;
        
        for (int i = 0; i < sharkTest.size(); i++) {
            System.out.println(sharkTest.get(i).toString());
        }
        
        Collections.sort(sharkTest, new Comparator<shark>() {
            @Override
            public int compare(shark o1, shark o2) {
                if(o1.time == o2.time){
                    if(o1.Y == o2.Y){
                        return o1.X -o2.X;
                    }
                    return o1.Y - o2.Y;
                }
                return o1.time - o2.time;
            }
        });

        System.out.println("=================================");
        for (int i = 0; i < sharkTest.size(); i++) {
            System.out.println(sharkTest.get(i).toString());
        }

        Arrays.sort(test,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    if(o1[1] == o2[1]){
                        return o1[2] - o2[2];
                    }
                    return o2[1] - o1[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });

        for (int i = 0; i < test.length; i++) {
            System.out.println(Arrays.toString(test[i]));
        }

    }
}
