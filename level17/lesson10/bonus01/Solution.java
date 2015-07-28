package com.javarush.test.level17.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException{

        SimpleDateFormat dtoL = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dtoO = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);

        if (args[0].equals("-c")){
            Person person=null;
            if (args[2].equals("м")) person=Person.createMale(args[1], dtoL.parse(args[3]));
            if (args[2].equals("ж")) person=Person.createFemale(args[1], dtoL.parse(args[3]));
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }

        if (args[0].equals("-u")){
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(dtoL.parse(args[4]));
            if (args[2].equals("м")) allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
            if (args[2].equals("ж")) allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
        }

        if (args[0].equals("-d")){
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
        }

        if (args[0].equals("-i")){
            Person person = allPeople.get(Integer.parseInt(args[1]));
            if (person.getSex().equals(Sex.FEMALE)){
            System.out.println(person.getName()+" ж "+dtoO.format(person.getBirthDay()));
            }
            else System.out.println(person.getName()+" м "+dtoO.format(person.getBirthDay()));
        }
    }
}
