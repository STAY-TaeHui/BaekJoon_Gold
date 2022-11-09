package com.silver.설탕배달_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2839
public class Main {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int kg = Integer.parseInt(br.readLine());

        if (kg % 5 != 0 || kg % 3 != 0) {
            System.out.println(-1);
        }


    }
}
