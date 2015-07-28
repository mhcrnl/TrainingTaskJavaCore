package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        BufferedReader buf=null, bur=null;
        try{
            buf = new BufferedReader(new InputStreamReader(System.in));
            String file = buf.readLine();
            bur = new BufferedReader(new FileReader(file));
            while (bur.ready()){
                int c=0;
                String fs = bur.readLine();
                String[] sa = fs.replaceAll("\\p{Punct}"," ").split(" ");
                for (String in : sa)
                    for (String lin : words) if (lin.equals(in)) c++;
                if (c==2) System.out.println(fs);
            }
        }catch (Exception e) {}
        finally
        {
            try{
                if (bur!=null) bur.close();
                if (buf!=null) buf.close();
            }catch (Exception e){}
        }

    }
}
