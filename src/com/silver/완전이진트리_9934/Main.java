package com.silver.완전이진트리_9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main
{
    static int[] nodes = null;
    static List<StringBuilder> sbList = null;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int depth = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int nodeCount = st.countTokens();

        nodes = new int[nodeCount];
        sbList = new ArrayList<StringBuilder>(depth);

        for(int i=0; i< depth; i++){
            sbList.add(new StringBuilder());
        }

        for (int i = 0; i < nodeCount; i++)
        {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        cutting((int) (nodeCount - Math.pow(2,depth-1)),depth-1);

        for(int i=depth-1; i>=0; i--){
            System.out.println(sbList.get(i));
        }
    }

    private static void cutting(int point,int depth)
    {

            if (point % 2 == 0)
            {
                sbList.get(depth).append(nodes[point]).append(" ");
            }
            else
            {
                cutting((int) (point-Math.pow(2,depth-1)), depth-1);
                sbList.get(depth).append(nodes[point]).append(" ");
                cutting((int) (point +Math.pow(2,depth-1)), depth-1);

            }
    }

}
