package com.javarush.test.level06.lesson11.home06;

/* KissMyShinyMetalAss
Создай класс с именем KissMyShinyMetalAss. Создай объект этого класса, выведи его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        KissMyShinyMetalAss kma=new KissMyShinyMetalAss("Bob", 3);
        System.out.println(kma);
    }

    public static class KissMyShinyMetalAss
    {
        String name;
        int count;
        KissMyShinyMetalAss(String n, int c)
        {
            name=n;
            count=c;
        }
    }

}
