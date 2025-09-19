import java.util.*;

public class BMIProgram {
    public static double bmi(double w,double h){h=h/100;return w/(h*h);}
    public static String bmiStatus(double b){
        if(b<18.5)return"Underweight";
        else if(b<25)return"Normal";
        else if(b<30)return"Overweight";
        else return"Obese";
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double[][] team=new double[10][3];
        String[] status=new String[10];
        for(int i=0;i<10;i++){
            team[i][0]=sc.nextDouble();
            team[i][1]=sc.nextDouble();
            team[i][2]=bmi(team[i][0],team[i][1]);
            status[i]=bmiStatus(team[i][2]);
        }
        for(int i=0;i<10;i++)
            System.out.println(team[i][0]+" "+team[i][1]+" "+team[i][2]+" "+status[i]);
    }
}
