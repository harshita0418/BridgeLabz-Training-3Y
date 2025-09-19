import java.util.*;
public class NaturalSum {
    public static int rec(int n){if(n==0)return 0;return n+rec(n-1);}
    public static int formula(int n){return n*(n+1)/2;}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n<=0)System.out.println("Not Natural");
        else{
            int r1=rec(n),r2=formula(n);
            System.out.println(r1+" "+r2);
        }
    }
}
