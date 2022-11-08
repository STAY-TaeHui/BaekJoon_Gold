package com.silver.일로만들기_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1463
public class Main {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        dp = new Integer[x+1];
        dp[0] = dp[1] = 0;

        System.out.println(recursive(x));

    }
    static int recursive(int x){
        if(dp[x] == null){
            //6으로 나눠질때
            if(x%6==0){
                dp[x] = Math.min(recursive(x-1),Math.min(recursive(x/3),recursive(x/2)))+1;
            } else if (x % 3 == 0) {
                dp[x] = Math.min(recursive(x/3),recursive(x-1))+1;
            } else if (x % 2 == 0) {
                dp[x] = Math.min(recursive(x/2),recursive(x-1))+1;
            }
            else{
                dp[x] = recursive(x-1)+1;
            }
        }
        return dp[x];
    }
}
