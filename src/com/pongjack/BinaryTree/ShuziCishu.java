package com.pongjack.BinaryTree;

import java.util.Scanner;

public class ShuziCishu {
    public static void main(String[] args){
        int a[];
        a= new int[]{0};
        int num=0;
        int n = 0;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            a[n]++;
            num++;
        }
        for(int i=0;i<101;i++){
            if(a[i]>=num/2){
                System.out.println( i );
            }
        }
    }
}
