package algorithm1216;

public class bj2110 {
    public static int[] houses;

    public static void div(int searchN) {

        int left = 0;
        int right = 0 ;
        int mid = 0;
        while (left < right) {
            if (houses[mid] == searchN) {

                break;
            }

            if (houses[mid] < searchN) {
                left = mid + 1;
            } else if (houses[mid] >= searchN) {
                right = mid - 1;
            }

        }
    }
    
    
    public static void main(String[] args) {
        



    }
}
