package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bur = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        String s = bur.readLine();
        fillList(list,afterQ(s));
        printList(getParam(list));


    }

    public static String afterQ(String a){
        if (a.contains("?"))
        {
            int in = a.indexOf("?");
            a = a.substring(in + 1);
        }
      return a;
    }

    public static void fillList(ArrayList<String> list, String s){
        String[] sm = s.split("&");
        for (String st : sm)
        {
            list.add(st);
        }
    }

    public static ArrayList<String> getParam(ArrayList<String> list)
    {
        ArrayList<String> newList = new ArrayList<String>();
        for (String s : list)
        {
            if (s.contains("="))
            {
                String m[] = s.split("=");
                if (m[0].equals("obj"))
                {
                    newList.add(0, m[1]);
                    newList.add(m[0]);
                }
                else newList.add(m[0]);
            }
            else newList.add(s);
        }
        return newList;
    }

    public static void printList(ArrayList<String> list)
    {
        if (list.contains("obj"))
        {
            for (int i=1; i<list.size(); i++)
            {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            try{
                alert(Double.parseDouble(list.get(0)));
            }
            catch(Exception e){
                alert(list.get(0));
            }
        }
        else
        {
            for (String s : list) System.out.print(s + " ");
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
