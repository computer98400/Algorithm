package DataStructure;

public class mkcheck {

    protected int N  = 3;

    //해당 클래스 안에서만 사용하는 것.
    private int N2  = 4;
    

    public int getN2() {
    
        return N2;
    
    }

    public void setN2(int n2) {
    
        N2 = n2;
    
    }



    int N3 = 5;
    static int N5 = 66;
    public int N4 = 6;


    // DAO DTO
    private static int getInstance;

    public String id;
    public String pw;
    public int number;

    //아이디 비밀번호 고유넘버  -> 오버로딩
    public void update(String id){
        System.out.println("heelo");
    }

    public void update(int number){
        System.out.println("heelo");
    }

    public void update(String id, String pw){
        System.out.println("heelo");
    }



}
