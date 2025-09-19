import java.util.*;

public class Friends {
    public static int youngest(int[] ages){int m=0;for(int i=1;i<3;i++)if(ages[i]<ages[m])m=i;return m;}
    public static int tallest(int[] h){int m=0;for(int i=1;i<3;i++)if(h[i]>h[m])m=i;return m;}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] ages=new int[3],h=new int[3];
        for(int i=0;i<3;i++)ages[i]=sc.nextInt();
        for(int i=0;i<3;i++)h[i]=sc.nextInt();
        System.out.println(youngest(ages));
        System.out.println(tallest(h));
    }
}
