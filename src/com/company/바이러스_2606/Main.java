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
public class Main
{
    static BufferedReader br = null;
    static StringBuilder sb = null;
    static StringTokenizer virusLine = null;
    static int[][] adjArray = null;
    static LinkedList<Integer>[] adjList = null;
    static boolean[] check = null;
    static int count=1;

    public static void main(String[] args) throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());
        int commandCount = Integer.parseInt(br.readLine());

//        resultByStack(computerCount, commandCount);
//        resultByAdjArray(computerCount, commandCount);
        resultByLinkedList(computerCount,commandCount);

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
        printLine(computerCount);

        dfs_recursive(adjArray,1);

        System.out.println(count);
    }
    private static void dfs_recursive(int[][] adjArray, int computer){
        System.out.println("computer : " + computer);
        if(check[computer])return;

        check[computer]=true;
        for(int i=1; i<adjArray[0].length;i++){
                if(adjArray[computer][i] == 1){
                    count++;
                    System.out.println("count : " + count);
                    dfs_recursive(adjArray,i);
                }
        }
    }

    private static void printLine(int computerCount)
    {
        for (int i = 0; i <= computerCount; i++)
        {
            for (int j = 0; j <= computerCount; j++)
            {
                System.out.print(adjArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void resultByLinkedList(int computerCount, int commandCount) throws IOException
    {
        adjList = new LinkedList[computerCount+1];
        for(int i=0; i<=computerCount; i++){
            adjList[i] = new LinkedList<>();
        }

        for(int i=0; i<commandCount; i++){
            virusLine = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(virusLine.nextToken());
            int b = Integer.parseInt(virusLine.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        check = new boolean[computerCount+1];
        /*Stack 시작*/

        Stack<Integer> stack = new Stack<>();

        stack.push(1);

        int count=-1;
        while(stack.size()>0){
            int index=stack.pop();
            if(check[index])continue;
            check[index]=true;
            count++;

            for (Integer computer : adjList[index])
            {
                if(check[computer]){
                    continue;
                }
                stack.push(computer);
            }
        }
        System.out.println(count);
    }

}
