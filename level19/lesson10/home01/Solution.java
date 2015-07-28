package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bur = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> personList = new TreeMap<String, Double>();
        while (bur.ready()){
            String s = bur.readLine();
            String[] sa = s.split(" ");
            if (personList.get(sa[0])==null) personList.put(sa[0], Double.parseDouble(sa[1]));
            else personList.put(sa[0], personList.get(sa[0])+Double.parseDouble(sa[1]));
        }
        for (Map.Entry<String, Double> me : personList.entrySet()){
            System.out.println(me.getKey()+" "+me.getValue());
        }
        bur.close();
    }
}
