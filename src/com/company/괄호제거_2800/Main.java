package com.company.괄호제거_2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Vector;

/*
https://www.acmicpc.net/problem/2800
어떤 수식이 주어졌을 때, 괄호를 제거해서 나올 수 있는 서로 다른 식의 개수를 계산하는 프로그램을 작성하시오.

이 수식은 괄호가 올바르게 쳐져 있다. 예를 들면, 1+2, (3+4), (3+4*(5+6))와 같은 식은 괄호가 서로 쌍이 맞으므로 올바른 식이다.
하지만, 1+(2*3, ((2+3)*4 와 같은 식은 쌍이 맞지 않는 괄호가 있으므로 올바른 식이 아니다.
괄호를 제거할 때는, 항상 쌍이 되는 괄호끼리 제거해야 한다.
예를들어 (2+(2*2)+2)에서 괄호를 제거하면, (2+2*2+2), 2+(2*2)+2, 2+2*2+2를 만들 수 있다. 하지만, (2+2*2)+2와 2+(2*2+2)는 만들 수 없다. 그 이유는 쌍이 되지 않는 괄호를 제거했기 때문이다.
어떤 식을 여러 쌍의 괄호가 감쌀 수 있다.
* */
public class Main
{
    static BufferedReader br = null;
    static StringBuilder sb = null;
    static Stack<Integer> stk = null;

    static String str = null;
    static int[] pair = null;

    public static void main(String[] args) throws IOException
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        stk = new Stack<>();

        str = br.readLine();
        int len = str.length();
        pair = new int[len];

        for(int i=0; i<len; i++){
            char ch = str.charAt(i);
            if('('==ch){
                stk.push(i);
            }
            else if(ch==')'){
                pair[i] = stk.peek();
                pair[stk.peek()] = i;
                stk.pop();
            }
        }

    }
}