package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        isDateOdd("JANUARY 22 2015");

    }

    public static boolean isDateOdd(String date)
    {
        Date dat = new Date(date);
        int year = dat.getYear();
        Date fd = new Date(year, 0, 1);

        long msd = 24*60*60*1000;
        long td = dat.getTime() - fd.getTime() + msd;
        int dc = (int) (td/msd);
        return dc%2>0;
    }

/*    public static void pri(String date)
    {
        Date dat = new Date(date);
        int year = dat.getYear();
        Date fd = new Date(year, 0, 1);
       // fd.setYear(year);
       // fd.setMonth(0);
       // fd.setDate(1);
        long msd = 24*60*60*1000;
        long td = dat.getTime() - fd.getTime() +msd;
        long res = td/msd;
        int dc = (int) res;
        System.out.println(dc);
        //System.out.println(fd.getDate());
        //System.out.println(dat.getDate()-fd.getDate());
    }*/
}
