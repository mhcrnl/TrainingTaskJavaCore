package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] a = new ArrayList[5];
        a[0] = new ArrayList<String>();
        a[1] = new ArrayList<String>();
        a[2] = new ArrayList<String>();
        a[3] = new ArrayList<String>();
        a[4] = new ArrayList<String>();
        a[0].add("Cozzy");
        a[0].add("Cozimo");
        a[1].add("Poppy");
        a[2].add("Corny");
        a[3].add("Logic");
        a[3].add("Logos");
        a[4].add("Bobby");
        return a;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}