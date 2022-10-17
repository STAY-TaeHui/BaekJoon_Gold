package com.company.트리의순회_2263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main
{
    /*
        3
        1 2 3
        1 3 2
    */
    /*
7
4 2 5 1 6 3 7
4 5 2 6 7 3 1
        R 1 3 7 6 2 5 4
        > 1 2 4 5 3 6 7
    */
    /*
15
8 4 9 2 10 5 11 1 12 6 13 3 14 7 15
8 9 4 10 11 5 2 12 13 6 14 15 7 3 1
        > 1 2 4 8  9  5 10 11 3 6 12 13 7 14 15
        R 1 3 7 15 14 6 13 12 2 5 11 10 4  9  8
        > 0 1 2 3  4  5 6  7  8 9 10 11 12 13 14
    *  */
    static String[] temp = null;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCount = Integer.parseInt(br.readLine());

        int depth = (int) (Math.log(nodeCount)/Math.log(2));

        String[] inOrder = br.readLine().split(" ");
        String[] postOrder = br.readLine().split(" ");

        if(nodeCount==1){
            System.out.println(inOrder[0]);
            return;
        }

        temp= new String[nodeCount];

        List<String> postOrderList = Arrays.asList(postOrder);
        Collections.reverse(postOrderList);

        toPreOrder(postOrder, 1,depth);

        for (String s : postOrder)
        {
            System.out.print(s+" ");

        }

    }

    private static void toPreOrder(String[] postOrder, int point, int depth)
    {
        int distance= (int) Math.pow(2,depth)-1;

        for(int i=point; i<point+distance; i++){

            temp[i] = postOrder[i];
            postOrder[i] = postOrder[i+distance];
            postOrder[i+distance] = temp[i];
        }
        if(depth==1){
            return;
        }
        toPreOrder(postOrder,point+1,depth-1);

        toPreOrder(postOrder,point+distance+1,depth-1);
    }
}
