package algorithm0127;


public class bj14503 {

    public static int[] vacuum;
    public static boolean[][] visited;
    public static int[][] map;
    public static int direction;
    public static int[] dirY = {-1,0,1,0};
    public static int[] dirX = {0,1,0,-1};


    public static void clean() {
        if (!visited[vacuum[0]][vacuum[1]]) {
            visited[vacuum[0]][vacuum[1]] = true;
        }
    }

    public static void back() {
        

    }
    public static void search() {
        

    }

    public static void main(String[] args) {
        



    }


}