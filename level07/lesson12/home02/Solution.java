package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        ArrayList<String> list = new ArrayList<String>();
        //System.out.println("Enter "+n+" elements");
        for (int i=0; i<n; i++)
        {
            list.add(reader.readLine());
        }
        ArrayList<String> clist = moveALS(list,m);
        for (String q : clist)
        {
            System.out.println(q);

        }

    }
    public static ArrayList<String> moveALS(ArrayList<String> list, int c)
    {
        for (int i=0; i<c; i++)
        {
            list.add(list.get(0));
            list.remove(0);
        }
        return list;
    }
}
