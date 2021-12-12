package algorithm1212;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1063_notSolve {

    public static int[] dirY = {0,0,1,-1,-1,-1,1,1};
    public static int[] dirX = { 1, -1, 0, 0, 1, -1, 1, -1 };
    public static int kingY;
    public static int kingX;
    public static int stoneY;
    public static int stoneX;


    public static void order(String ord) {
        
        switch (ord) {
            case "R":
                if(kingX+dirX[0] >=0 &&kingY+dirY[0] >=0 && kingX+dirX[0] < 8 && kingY+dirY[0] < 8){
                    if (stoneY == kingY && stoneX == kingX) {
                        if (stoneY + dirY[0] >= 0 && stoneX + dirX[0] >= 0 && kingY + dirY[0] >= 0
                                && kingX + dirX[0] >= 0) {
                            stoneY += dirY[0];
                            stoneX += dirX[0];
                            kingY += dirY[0];
                            kingX += dirX[0];
                        } else {
                            break;
                        }
                    } else {
                        kingY += dirY[0];
                        kingX += dirX[0];
                    }
                }
            break;

            case "L":
            if(kingX+dirX[1] >=0 &&kingY+dirY[1] >=0 && kingX+dirX[1] < 8 && kingY+dirY[1] < 8){
                if (stoneY == kingY && stoneX == kingX) {
                    if (stoneY + dirY[1] >= 0 && stoneX + dirX[1] >= 0 && kingY + dirY[1] >= 0
                            && kingX + dirX[1] >= 0) {
                        stoneY += dirY[1];
                        stoneX += dirX[1];
                        kingY += dirY[1];
                        kingX += dirX[1];
                    } else {
                        break;
                    }
                } else {
                    kingY += dirY[1];
                    kingX += dirX[1];
                }
            }
            break;

            case "B":
            if(kingX+dirX[2] >=0 &&kingY+dirY[2] >=0 && kingX+dirX[2] < 8 && kingY+dirY[2] < 8){
                if (stoneY == kingY && stoneX == kingX) {
                    if (stoneY + dirY[2] >= 0 && stoneX + dirX[2] >= 0 && kingY + dirY[2] >= 0
                            && kingX + dirX[2] >= 0) {
                        stoneY += dirY[2];
                        stoneX += dirX[2];
                        kingY += dirY[2];
                        kingX += dirX[2];
                    } else {
                        break;
                    }
                } else {
                    kingY += dirY[2];
                    kingX += dirX[2];
                }
            }
            break;

            case "T":
            if(kingX+dirX[3] >=0 &&kingY+dirY[3] >=0 && kingX+dirX[3] < 8 && kingY+dirY[3] < 8){
                if (stoneY == kingY && stoneX == kingX) {
                    if (stoneY + dirY[3] >= 0 && stoneX + dirX[3] >= 0 && kingY + dirY[3] >= 0
                            && kingX + dirX[3] >= 0) {
                        stoneY += dirY[3];
                        stoneX += dirX[3];
                        kingY += dirY[3];
                        kingX += dirX[3];
                    } else {
                        break;
                    }
                } else {
                    kingY += dirY[3];
                    kingX += dirX[3];
                }
            }
            break;

            case "RT":
            if(kingX+dirX[4] >=0 &&kingY+dirY[4] >=0 && kingX+dirX[4] < 8 && kingY+dirY[4] < 8){
                if (stoneY == kingY && stoneX == kingX) {
                    if (stoneY + dirY[4] >= 0 && stoneX + dirX[4] >= 0 && kingY + dirY[4] >= 0
                            && kingX + dirX[4] >= 0) {
                        stoneY += dirY[4];
                        stoneX += dirX[4];
                        kingY += dirY[4];
                        kingX += dirX[4];
                    } else {
                        break;
                    }
                } else {
                    kingY += dirY[4];
                    kingX += dirX[4];
                }
            }
            break;

            case "LT":
            if(kingX+dirX[5] >=0 &&kingY+dirY[5] >=0 && kingX+dirX[5] < 8 && kingY+dirY[5] < 8){
                if (stoneY == kingY && stoneX == kingX) {
                    if (stoneY + dirY[5] >= 0 && stoneX + dirX[5] >= 0 && kingY + dirY[5] >= 0
                            && kingX + dirX[5] >= 0) {
                        stoneY += dirY[5];
                        stoneX += dirX[5];
                        kingY += dirY[5];
                        kingX += dirX[5];
                    } else {
                        break;
                    }
                } else {
                    kingY += dirY[5];
                    kingX += dirX[5];
                }
            }
            break;

            case "RB":
            if(kingX+dirX[6] >=0 &&kingY+dirY[6] >=0 && kingX+dirX[6] < 8 && kingY+dirY[6] < 8){
                if (stoneY == kingY && stoneX == kingX) {
                    if (stoneY + dirY[6] >= 0 && stoneX + dirX[6] >= 0 && kingY + dirY[6] >= 0
                            && kingX + dirX[6] >= 0) {
                        stoneY += dirY[6];
                        stoneX += dirX[6];
                        kingY += dirY[6];
                        kingX += dirX[6];
                    } else {
                        break;
                    }
                } else {
                    kingY += dirY[6];
                    kingX += dirX[6];
                }
            }
            break;

            case "LB":
            if(kingX+dirX[7] >=0 &&kingY+dirY[7] >=0 && kingX+dirX[7] < 8 && kingY+dirY[7] < 8){
                if (stoneY == kingY && stoneX == kingX) {
                    if (stoneY + dirY[7] >= 0 && stoneX + dirX[7] >= 0 && kingY + dirY[7] >= 0
                            && kingX + dirX[7] >= 0) {
                        stoneY += dirY[7];
                        stoneX += dirX[7];
                        kingY += dirY[7];
                        kingX += dirX[7];
                    } else {
                        break;
                    }
                } else {
                    kingY += dirY[7];
                    kingX += dirX[7];
                }
            }
            break;
        }
    }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        
        String king = st.nextToken();
        String stone = st.nextToken();

        kingY = king.charAt(1)-'1';
        kingX = (int) (king.charAt(0)-'A');
        stoneY = stone.charAt(1)-'1';
        stoneX = (int) stone.charAt(0) - 'A';
        int orders = Integer.parseInt(st.nextToken());
        String temp;
        for (int i = 0; i < orders; i++) {
            temp = sc.nextLine();
            order(temp);
        }
        System.out.println(kingY + "   " + kingX);
        System.out.println(stoneY + "   " + stoneX);

    }
}
