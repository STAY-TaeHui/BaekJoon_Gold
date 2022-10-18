package com.silver.숨바꼭질_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1697
/*
* N : 5
* K : 17
* N - K = -12 == V
* V % 2 == 0 -> v/2
* v % 2 != 0 -> v/2+1
* */
public class Main {
    static BufferedReader br = null;
    static int[] check = new int[100001];
    static int N, K;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N= Integer.parseInt(st.nextToken());
         K= Integer.parseInt(st.nextToken());
        int dist = Math.abs(N - K);

        bfs(N);
    }

    private static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n]=1;

        while(!q.isEmpty()){
            int X = q.poll();


        }


    }
}
