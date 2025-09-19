import java.util.*;
public class Factors {
    public static int[] findFactors(int n){
        int c=0;for(int i=1;i<=n;i++)if(n%i==0)c++;
        int[] a=new int[c];int k=0;
        for(int i=1;i<=n;i++)if(n%i==0)a[k++]=i;
        return a;
    }
    public static int sum(int[] a){int s=0;for(int x:a)s+=x;return s;}
    public static int product(int[] a){int p=1;for(int x:a)p*=x;return p;}
    public static int sumSquares(int[] a){int s=0;for(int x:a)s+=Math.pow(x,2);return s;}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] f=findFactors(n);
        System.out.println(Arrays.toString(f));
        System.out.println(sum(f));
        System.out.println(sumSquares(f));
        System.out.println(product(f));
    }
}
