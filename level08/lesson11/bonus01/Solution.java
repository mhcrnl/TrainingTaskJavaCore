package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buR = new BufferedReader(new InputStreamReader(System.in));
        String moon = buR.readLine();
        String date = moon+" 1 "+"2000";
        Date d = new Date(date);
        int mon = d.getMonth()+1;
        System.out.println(moon+" is "+mon+" month");

    }

}
