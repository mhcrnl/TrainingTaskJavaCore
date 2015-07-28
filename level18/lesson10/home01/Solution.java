package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fos = new FileInputStream(args[0]);
        int c=0;
        while (fos.available()>0){
            String a = String.valueOf((char) fos.read());
            if (a.matches("^[a-zA-Z]$")) c++;
        }
        System.out.println(c);
        fos.close();
    }
}
