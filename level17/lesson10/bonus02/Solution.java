package com.javarush.test.level17.lesson10.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException, IOException{

            SimpleDateFormat dtoL = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat dtoO = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            if (args[0].equals("-c"))
            {
                synchronized (Solution.class)
                {
                    for (int i = 1; i < args.length; i=i+ 3)
                    {
                        Person person = null;
                        if (args[i + 1].equals("м")) person = Person.createMale(args[i], dtoL.parse(args[i + 2]));
                        if (args[i + 1].equals("ж")) person = Person.createFemale(args[i], dtoL.parse(args[i + 2]));
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                }
            }

            if (args[0].equals("-u"))
            {
                synchronized (Solution.class)
                {
                    for (int i = 1; i < args.length; i+=4)
                    {
                        allPeople.get(Integer.parseInt(args[i])).setName(args[i + 1]);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDay(dtoL.parse(args[i + 3]));
                        if (args[i + 2].equals("м")) allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                        if (args[i + 2].equals("ж")) allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
                    }
                }
            }

            if (args[0].equals("-d"))
            {
                synchronized (Solution.class)
                {
                    for (int i = 1; i < args.length; i++)
                    {
                        allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                    }
                }
            }

            if (args[0].equals("-i"))
            {
                synchronized (Solution.class)
                {
                    for (int i = 1; i < args.length; i++)
                    {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        if (person.getSex().equals(Sex.FEMALE))
                        {
                            System.out.println(person.getName() + " ж " + dtoO.format(person.getBirthDay()));
                        } else System.out.println(person.getName() + " м " + dtoO.format(person.getBirthDay()));
                    }
                }
            }
    }
}
