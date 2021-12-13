package algorithm1213;
import java.util.Scanner;

public class bj2033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k=10;
		int a=sc.nextInt();
		while(a>k)
		{
					
			if( a%k <k/2)
				a=a-a%k;
			else if(a%k >=k/2)
				{
					a=a-a%k;
					a+=k;
				}
			k*=10;	
		}
		System.out.print(a);


    }
}
