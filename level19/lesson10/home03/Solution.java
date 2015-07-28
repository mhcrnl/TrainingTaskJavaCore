package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        BufferedReader bur=null;
        try
        {
            bur = new BufferedReader(new FileReader(args[0]));
            while (bur.ready())
            {
                String s = bur.readLine();
                if (s.equals("")) continue;
                String[] sa = s.split(" ");
                SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy");
                Date date = df.parse(sa[sa.length - 3]+" "+sa[sa.length - 2]+" "+sa[sa.length - 1]);
                String name = sa[0];
                for (int i = 1; i < sa.length - 3; i++) name += " " + sa[i];
                PEOPLE.add(new Person(name, date));
            }
            for (Person p : PEOPLE) System.out.println(p.getName()+" "+p.getBirthday());
        }catch (Exception e){}
        finally
        {
            try{ if (bur!=null) bur.close(); }
            catch (Exception e){}

        }
    }

}
