package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        int w=0;
        while(true)
        {
            String s=buf.readLine();
            if (s.equals("сумма"))
            {
                System.out.println(w);
                break;
            }
            else
            {
                int q =Integer.valueOf(s);
                w+=q;
            }

        }
    }
}
