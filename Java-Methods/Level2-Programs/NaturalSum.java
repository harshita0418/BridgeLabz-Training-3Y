import java.util.*;

public class NaturalSum {
    public static int sumRec(int n){if(n==0)return 0;return n+sumRec(n-1);}
    public static int sumFormula(int n){return n*(n+1)/2;}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(sumRec(n));
        System.out.println(sumFormula(n));
    }
}
x
