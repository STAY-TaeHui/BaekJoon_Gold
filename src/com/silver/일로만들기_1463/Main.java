package com.silver.일로만들기_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1463
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long x = Long.parseLong(br.readLine());
        long count=0;
        while(x!=1){
            System.out.print(x + " " );

            if(x>=3) {
                if (x % 3 != 0) {
                    long trash = x % 3;
                    x = x - trash;
                    count += trash;
                    if(trash>1)
                    System.out.print(" * ");
                    continue;
                } else if (x % 3 == 0) {
                    x = x / 3;
                }
            }
            else if (x % 2 == 0 && x>=2) {
                x=x/2;
            }
            else{
                x-=1;
            }
            count++;
        }
        System.out.print(1);
        System.out.println();
        System.out.println("count = " + count);
    }
}
