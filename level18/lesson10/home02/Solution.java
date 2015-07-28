package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.util.Locale;


public class Solution {
    public static void main(String[] args) throws Exception{
        if (args.length>0)
        {
            FileInputStream fos = new FileInputStream(args[0]);
            int n1 = 0;
            int n2 = 0;
            while (fos.available() > 0)
            {
                if (fos.read() == 32) n2++;
                n1++;
            }
            double res = (double) n2 / n1 * 100;
            System.out.printf(Locale.ENGLISH, "%.2f", res);
            fos.close();
        }
    }
}
