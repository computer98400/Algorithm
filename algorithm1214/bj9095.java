package algorithm1214;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class bj9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader b =new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(b.readLine());
        int[] a={0,1,2,4,7,13,24,44,81,149,274};
        StringBuilder s=new StringBuilder();
        for(int i=0;i<N;i++)s.append(a[Integer.parseInt(b.readLine())]+"\n");
        System.out.println(s);
    }
}
