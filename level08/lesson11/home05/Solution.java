package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        String cs = new String();
        int len = s.length();
        cs+=s.charAt(0);

        if (!cs.equals(" ")) cs=cs.toUpperCase();
        for (int i=1; i<len-1; i++)
        {
            String its = s.substring(i,i+1);
            if (its.equals(" "))
            {
                cs+=its;
                continue;
            }
            else if (s.substring(i-1,i).equals(" "))
            {
                cs+=its.toUpperCase();
            }
            else cs+=its;

        }

        cs+=s.charAt(len-1);

        System.out.println(cs);
    }


}
