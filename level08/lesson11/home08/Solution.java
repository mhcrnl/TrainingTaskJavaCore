package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array)
    {
        int[] cop = new int[array.length];

        for (int k=0; k<array.length; k++)
        {
            cop[k]=array[k];
        }

        for (int i=0; i<cop.length; i++)
        {
            int max = cop[i];
            int c=i;
            int q;
            for (int j=i+1; j<cop.length; j++)
            {
                if (cop[j]>max)
                {
                    max=cop[j];
                    c=j;
                }
            }
            array[i]=max;
            q=cop[i];
            cop[i]=cop[c];
            cop[c]=q;
        }

    }

/*    public static int max(int[] array)
    {
        int max = array[0];
        for (int i=1; i<array.length; i++)
        {
            if (array[i]>max) max=array[i];
        }
        return max;
    }*/

}
