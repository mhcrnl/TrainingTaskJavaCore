package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        Map<String, String> addresses = new HashMap<String, String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            String f = reader.readLine();

            addresses.put(s, f);
        }

        //read home number
        //int houseNumber = Integer.parseInt(reader.readLine());
        String sity = reader.readLine();

        //Iterator<Map.Entry<String, String>> iterator = addresses.entrySet().iterator();
        if (addresses.containsKey(sity))
        {
            String familySecondName = addresses.get(sity);
            System.out.println(familySecondName);
        }
    }
}
