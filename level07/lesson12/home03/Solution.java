package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int  maximum;
        int  minimum;

        int[] m = new int[20];

        for (int i=0; i<m.length; i++)
        {
            m[i] = Integer.parseInt(reader.readLine());
        }
        maximum = maxi(m);
        minimum = mini(m);
        System.out.print(maximum+" "+minimum);
        //System.out.println(minimum);
    }
    public static int maxi(int[] mas)
    {
        int max=mas[0];
        for (int i=1; i<mas.length; i++)
        {
            if (max<mas[i]) max=mas[i];
        }
        return max;
    }

    public static int mini(int[] mas)
    {
        int min=mas[0];
        for (int i=1; i<mas.length; i++)
        {
            if (min>mas[i]) min=mas[i];
        }
        return min;
    }
}
