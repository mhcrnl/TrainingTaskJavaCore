package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bur = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bur.readLine());
        int b = Integer.parseInt(bur.readLine());
        System.out.println(NOD(a,b));
    }
    public static int NOD(int a, int b)
    {
        int nod=1;
        for (int i=1; i<=max(a,b); i++)
        {
            if (a%i==0 && b%i==0)
            {
                nod = i;
            }
        }
        return nod;
    }
    public static int max(int a,int b)
    {
        int max;
        if (a>=b) max=a;
        else max=b;
        return max;
    }
}
