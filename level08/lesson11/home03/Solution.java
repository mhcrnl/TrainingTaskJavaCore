package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        Map<String, String> pep = new HashMap<String, String>();
        pep.put("Van", "Dam");
        pep.put("Kuk", "Chack");
        pep.put("Klein", "Bill");
        pep.put("Noris", "Chack");
        pep.put("Van", "Solen");
        pep.put("Kolins", "Chack");
        pep.put("Noris", "Lary");
        pep.put("Noris", "Bill");
        pep.put("Van", "Bob");
        pep.put("Ferre", "Dam");


        return pep;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
