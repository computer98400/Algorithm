package algorithm0904;

public class bj17140_2 {

    static class node implements Comparable<node>{
        int number;
        int count;

        public node(int number,int count){
            this.number = number;
            this.count = count;
        }
        @Override
        public int compareTo(node o) {
            if( this.count > o.count){
                return 1;
            }else if(this.count == o.count){
                if(this.number < o.number){
                    return 1;
                }else{
                    return 0;
                }
            }else{
                return -1;
            }
        }
        @Override
        public String toString() {
            return number+" "+count;
        }
    }



    public static void main(String[] args) {
        int[][] origin = new int[100][100];


    }
}
