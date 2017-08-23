package com.pongjack.BinaryTree;

import java.util.Scanner;

public class Max {

    private void getMaxval(int n,Long[] a,Long[] b){
        Long max1= Long.valueOf(0);
        Long max2=Long.valueOf(0);
        Long max3=Long.valueOf(0);
        int flag1 = 0;
        int flag2 =0;
        int flag3 =0;
        for(int i=0;i<n;i++) {
                max1 = Math.max(max1, a[i]);
                flag1 = i;
            }
            for(int i=0;i<n;i++) {
                max2 = Math.max(max2, b[i]);
                flag2 = i;
            }
            for(int i=0;i<n;i++) {
                max3 = Math.max(max3, a[i] * a[i] + b[i] * b[i]);
                flag3 = i;
            }//System.out.println( flag1+" "+flag2+" "+flag3 );
        for(int i =0;i<n;i++){
            if(i==flag1||i==flag2||i==flag3){
                System.out.println( a[i]+" "+b[i] );
            }
        }

    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Long[] a=new Long[n];
        Long[] b=new Long[n];
        for(int i=0;i<n;i++){
            a[i]=scanner.nextLong();
            //System.out.print( a[i] +" ");
            b[i]=scanner.nextLong();
            //System.out.print( b[i]+ " " );
        }
        Max max=new Max();
        max.getMaxval(n,a,b);
    }
}
