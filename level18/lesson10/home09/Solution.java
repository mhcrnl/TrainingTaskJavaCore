package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bur = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try
        {
            while (true)
            {
                s=bur.readLine();
                FileInputStream fis = new FileInputStream(s);
                fis.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(s);
        }
        catch (Exception e) {}
    }
}
