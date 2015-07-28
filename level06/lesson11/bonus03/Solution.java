package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static int c, v;
    static int [] num = new int[5];
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<5; i++)
        {
            num[i]=Integer.parseInt(reader.readLine());
        }

        for (int i=0; i<num.length-1; i++)
        {
            for (int j=0; j<num.length-i-1;j++)
            {
                if (num[j]>num[j+1])
                {
                    int q=num[j];
                    num[j]=num[j+1];
                    num[j+1]=q;

                }
            }
        }

        for (int i=0; i<5; i++)
        {
            System.out.println(num[i]);
        }

        /*while (c<5)
        {
            int q = Integer.parseInt(reader.readLine());
            list.add(q);
            c++;
        }
        while (list.size()!=0)
        {
            int k = 0;
            int min = list.get(0);
            for (int j = 1; j < list.size(); j++)
            {
                if (list.get(j) < min)
                {
                    min = list.get(j);
                    k = j;
                }
            }
            System.out.println(list.get(k));
            list.remove(k);
        }*/


    }

}
