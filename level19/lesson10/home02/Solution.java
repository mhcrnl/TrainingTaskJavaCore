package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bur = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> personList = new TreeMap<String, Double>();
        while (bur.ready()){
            String s = bur.readLine();
            String[] sa = s.split(" ");
            if (personList.get(sa[0])==null) personList.put(sa[0], Double.parseDouble(sa[1]));
            else personList.put(sa[0], personList.get(sa[0])+Double.parseDouble(sa[1]));
        }
        double max = personList.get(personList.firstKey());
        for (Double me : personList.values()){
            if (me>=max) max=me;
        }
        for (Map.Entry<String, Double> me : personList.entrySet()){
            if (max==me.getValue()) System.out.println(me.getKey());
        }
        bur.close();
    }
}
