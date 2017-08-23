package com.pongjack.BinaryTree;

import java.util.Scanner;

public class TestTT1 {

//    @Override
//    public String toString() {
//        return ;
//    }

    private static String result(String s, int start, int end){
        char[] tem = s.toCharArray();
        //char[] temp=new char[s.length()];
       // int index=0;
//        while (index<s.length()){
//            if(index<start||index>end){
//                temp[index] = tem[index];
//            }else{
//                temp[index] = tem[end-index-1];
//            }
//        }
        char [] result = new char[end];
        for(int i=start;i<end;i++){
            result[i-start] = tem[end-i-1];
        }
        String r = result.toString();
        StringBuffer s1= new StringBuffer(s);
        s1 = s1.append(r);
        System.out.println( s1 );
        s=s1.toString();
        if(s.length()>1000){
            throw new RuntimeException();
        }
        return s;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s;
        while (scanner.hasNext()){
            s = scanner.nextLine();
            if(s.length()>10){
                throw new RuntimeException();
            }
            int n = scanner.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            for(int i=0;i<n;i++){
                start[i]=scanner.nextInt();
                end[i] = scanner.nextInt();
                s=result(s,start[i],end[i]);
            }
            System.out.println( s );
        }
    }
}
