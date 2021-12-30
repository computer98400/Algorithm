package DataStructure;


public class test{

    static int test333 =4;

    public static void main(String[] args) {
        
        mkClass test = new mkClass();
        
        //인스턴스(휘발성) 지역,전역(비휘발성)

        mkcheck test2 = new mkcheck();
        
        System.out.println(test333);

        // System.out.println(test2.N);
        // System.out.println(test2.N3);
        // System.out.println(test2.N4);

        System.out.println(test2.N4);
        System.out.println(mkcheck.N5);



    }


}