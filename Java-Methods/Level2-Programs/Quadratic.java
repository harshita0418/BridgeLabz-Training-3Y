import java.util.*;

public class Quadratic {
    public static double[] quadratic(int a,int b,int c){
        double d=b*b-4*a*c;
        if(d<0)return new double[]{};
        if(d==0)return new double[]{-b/(2.0*a)};
        double r1=(-b+Math.sqrt(d))/(2*a),r2=(-b-Math.sqrt(d))/(2*a);
        return new double[]{r1,r2};
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
        double[] roots=quadratic(a,b,c);
        System.out.println(Arrays.toString(roots));
    }
}
