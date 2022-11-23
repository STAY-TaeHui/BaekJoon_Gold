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
        dp = new Integer[kg+1];

        recur(kg);
        System.out.println(dp[kg]);
    }
    static int recur(int kg)
    {
        if(kg<0){
            return -1;
        }

        if (dp[kg] == null)
        {
            if (kg % 5 == 0)
            {
                dp[kg] = recur(kg - 5)+1;
                System.out.println("dp["+kg+"] : " + dp[kg]);
            }
            else if (kg % 3 == 0)
            {
                dp[kg] = recur(kg - 3)+1;
                System.out.println("dp["+kg+"] : " + dp[kg]);
            }
            else
            {
                int max = Math.max(recur(kg - 5), recur(kg - 3));
                dp[kg] = max<0 ? -1 : max+1;
                System.out.println("dp["+kg+"] : " + dp[kg]);

            }
        }
        return dp[kg];

    }
}
