package Algorithm.algorithm1203;

import java.util.Scanner;

public class bj1074 {
    public static int count;
    //map
    public static int solutionY;
    public static int solutionX;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        solutionY = sc.nextInt();
        solutionX = sc.nextInt();
        divide(solutionY,solutionX,(int) Math.pow(2,size));

    }

    static void divide(int y, int x, int size){
        if(size == 2){
            if(solutionY == 0 && solutionX == 0){
                System.out.println(count);
                return;
            }else if(solutionY == 0 && solutionX == 1){
                System.out.println(count+1);
                return;
            }else if(solutionY == 1 && solutionX == 0){
                System.out.println(count+2);
                return;
            }else {
                System.out.println(count+3);
                return;
            }
        }
        //0 1 2 3 
        int div = size/2;
        if(y< div && x< div){
           // System.out.println("check");
            divide(y,x,div);    //0 1 2
        }else if(y < div && x>= div){
          //  System.out.println("check1");
            count += div*div;
            solutionX -= div;
            divide(y,x-div,div);
        }else if(y >= div && x< div){
        //    System.out.println("check2");
            count += div*div*2;
            solutionY -= div;
            divide(y-div,x,div);
        }else{
    //      System.out.println("check3");
      //    System.out.println("solutoinY: "+ solutionY+" solutionX: "+solutionX);
            count+= div*div*3;
            solutionY -= div;
            solutionX -= div;
            divide(y-div,x-div,div);
        }
    }
// 4 6 8
// 

}
