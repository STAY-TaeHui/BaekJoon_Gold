package com.company.스택_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
* https://www.acmicpc.net/problem/10828
* 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
명령은 총 다섯 가지이다.

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
* */
public class Main {

    public static void main(String[] args) throws IOException
    {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(br.readLine());

        List<Integer> stack = new ArrayList<>();

        while(commandCount-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            switch (st.countTokens())
            {
                case 0: // pop / size / empty / top
                    switch (command){
                        case "pop":
                            if(stack.size()>0){
                                Integer remove = stack.remove(stack.size()-1);
                                System.out.println(remove);
                            }
                            else System.out.println(-1);
                            break;
                        case "size":
                            System.out.println(stack.size());
                            break;
                        case "empty":
                            int i = stack.size() > 0 ? 0 : 1;
                            System.out.println(i);
                            break;
                        case "top":
                            if(stack.size()>0){
                                System.out.println(stack.get(stack.size()-1));
                            }
                            else System.out.println(-1);
                            break;
                        default:
                            break;
                    }
                case 1: // push
                    if ("push".equals(command))
                    {
                        Integer num = Integer.valueOf(st.nextToken());
                        stack.add(num);
                    }
                default:
                    break;
            }
        }

    }
}
