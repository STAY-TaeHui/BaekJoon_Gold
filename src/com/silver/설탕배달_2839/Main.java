package com.silver.설탕배달_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2839
public class Main {
    static Integer dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int kg = Integer.parseInt(br.readLine());
        dp = new Integer[kg];
        dp[0]=dp[1]=dp[2]=-1;

        System.out.println(recur(kg));
    }
    static int recur(int kg){
        if (dp[kg] == null)
        {
            if (kg % 5 == 0)
            {
                recur(kg-5);
            }
            else if (kg % 3 == 0)
            {
                dp[kg]=recur(kg-3);
            }
            int min = Math.min(kg % 5, kg % 3);
        }
        else
            return dp[kg];


    }
}
