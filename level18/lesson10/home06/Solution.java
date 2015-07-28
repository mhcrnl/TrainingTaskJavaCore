package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream(args[0]);
        TreeMap<Integer, Integer> wm = new TreeMap<Integer, Integer>();
        while (fis.available()>0){
            int s = fis.read();
            if (wm.containsKey(s)) wm.put(s,wm.get(s)+1);
            else wm.put(s,1);
        }
        for (Map.Entry<Integer,Integer> tm : wm.entrySet())
        {
            String ch = String.valueOf(Character.toChars(tm.getKey()));
            System.out.println(ch+" "+tm.getValue());
        }
        fis.close();
    }
}
