package com.pongjack.BinaryTree;

import jdk.nashorn.internal.runtime.regexp.RegExp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShuziChuan {
    private static int length=0;

    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        String test = scanner.nextLine();
        int count=0;
        char[] target=test.toCharArray();
        //char[][] result=new char[100][100];
        //int flag=0;
        int len=target.length;
        int maxlen=0;
        String maxStr =null;
        StringBuffer r=new StringBuffer();
        String s = null;
        while (count<len){
            if(target[count]>'9'||target[count]<'0'){
                count++;
                 length = 0;
                continue;
            }else  {
                if(length==0){
                    s=r.append(target[count]).toString();
                    count++;
                    r=new StringBuffer(s);
                    length++;
                }else {
                    s=r.append(target[count]).toString();
                    r=new StringBuffer(s);
                    count++;
                    length++;
                }
            }if(maxlen<length){
                maxlen =length;
                maxStr=s;
            }else {
                maxlen=0;
                maxStr=null;
            }
        }
        System.out.println( s );

    }
}
