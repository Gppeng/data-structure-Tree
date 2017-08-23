package com.pongjack.BinaryTree;

import java.util.Scanner;

public class T1 {

    private static String result(String s, int start, int len){
//        StringBuffer s1=new StringBuffer(s.substring(0,start));
//        StringBuffer s2=new StringBuffer(s.substring(start+len,s.length()-1));
//        //StringBuffer si=new StringBuffer(s);
////        if(len==1){
////            s=si.append(s.toCharArray()[start]).toString();
////            return  s;
////        }
//        StringBuffer append = new StringBuffer(s.substring(start,start+len));
//        //System.out.println( append );
//        StringBuffer ap=append.reverse();
//        //System.out.println( ap+"反转后的字符串是" );
//
//        s1=s1.append(append);
//        s=s1.append(s2).toString();
        String s1=s.substring(0,start+len-1);

       // System.out.println( s2 );
        StringBuffer sa=new StringBuffer(s1);
        StringBuffer sr=new StringBuffer(s.substring(start,start+len-1));
        if((start+len-1)<s.length()-1) {
            String s2 = s.substring(start + len - 1, s.length() - 1);
            StringBuffer sb = new StringBuffer(s2);
            s = sa.append(sr).append(sb).toString();
        }else {
            s=sa.append(sr).toString();
        }
        return s;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();
        if(test.length()>10){
            throw  new RuntimeException();
        }else {
            int n =scanner.nextInt();
            int[] start = new int[n];
            int[] len = new int[n];
            for(int i=0;i<n;i++){
                start[i] = scanner.nextInt();
                len[i] = scanner.nextInt();
                test = result(test,start[i],len[i]);
            }
        }
        System.out.println( test );
    }
}
