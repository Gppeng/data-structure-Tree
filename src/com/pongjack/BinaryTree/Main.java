package com.pongjack.BinaryTree;

import java.util.Scanner;

public class Main {
    private static int result(int n,int[] a){
        int max=-1000;
        for(int i=0;i<n;i++)
        for (int j=0;j<n;j++)
        {
            if(max<a[i]*a[j]){
                max=a[i]*a[j];
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a =new int[n];
        for(int i=0;i<n;i++){
            a[i] = scanner.nextInt();
        }
        int r=result(n,a);
        System.out.println( r );
    }
}
