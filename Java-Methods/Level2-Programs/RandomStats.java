import java.util.*;

public class RandomStats {
    public static int[] generate4DigitRandomArray(int size){
        int[] a=new int[size];
        for(int i=0;i<size;i++)a[i]=(int)(1000+Math.random()*9000);
        return a;
    }
    public static double[] findAverageMinMax(int[] n){
        int min=n[0],max=n[0],s=0;
        for(int x:n){s+=x;if(x<min)min=x;if(x>max)max=x;}
        return new double[]{s*1.0/n.length,min,max};
    }
    public static void main(String[] args){
        int[] nums=generate4DigitRandomArray(5);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(findAverageMinMax(nums)));
    }
}
