package com.javarush.test.level13.lesson11.bonus01;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

public class Solution
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader bur = new BufferedReader(new InputStreamReader(System.in));
            String name = bur.readLine();
            BufferedReader fbur = new BufferedReader(new FileReader(name));
            ArrayList<Integer> list = new ArrayList<Integer>();
            String n = fbur.readLine();
            while (n!=null)
            {
                list.add(Integer.parseInt(n));
                n = fbur.readLine();
            }
            ArrayList<Integer> ans = sort(even(list));
            for (Integer a : ans)
            {
                System.out.println(a);
            }
            fbur.close();
            bur.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static ArrayList<Integer> even(ArrayList<Integer> list)
    {
        ArrayList<Integer> evList = new ArrayList<Integer>();
        for (Integer a : list){
            if (a%2==0) evList.add(a);
        }
        return evList;
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> list)
    {
        for (int i=0; i<list.size(); i++)
            for (int j=0; j<list.size()-1-i; j++)
            {
                if (list.get(j)>list.get(j+1))
                {
                    int c = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, c);
                }
            }
        return list;
    }
}
