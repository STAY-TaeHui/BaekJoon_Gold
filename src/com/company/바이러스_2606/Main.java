package com.company.바이러스_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
*
7
6
1 2
2 3
1 5
5 2
5 6
4 7
* */
//https://www.acmicpc.net/problem/2606
public class Main
{
    static BufferedReader br = null;
    static StringBuilder sb = null;
    static StringTokenizer virusLine = null;
    static int[][] adjArray = null;
    static boolean[] check = null;
    static int count=0;

    public static void main(String[] args) throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());
        int commandCount = Integer.parseInt(br.readLine());

        resultByAdjArray(computerCount, commandCount);
        System.out.println(count);


    }

    private static void resultByAdjArray(int computerCount, int commandCount) throws IOException
    {
        adjArray = new int[computerCount + 1][computerCount + 1];
        check = new boolean[computerCount+1];
        for (int i = 0; i < commandCount; i++)
        {
            virusLine = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(virusLine.nextToken());
            int b = Integer.parseInt(virusLine.nextToken());
            adjArray[a][b] = 1;
            adjArray[b][a] = 1;
        }
        dfs(adjArray,1);

    }
    private static void dfs(int[][] adjArray, int computer){
        if(check[computer])return;

        check[computer]=true;
        for(int i=1; i<adjArray[0].length;i++){
            if(!check[i]){
                if(adjArray[computer][i] == 1){
                    count++;
                    dfs(adjArray,i);
                }
            }
        }
    }
}
