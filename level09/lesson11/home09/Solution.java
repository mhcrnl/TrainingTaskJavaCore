package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> map = new HashMap<String, Cat>();
        Cat a = new Cat("Antonio");
        Cat b = new Cat("Billi");
        Cat c = new Cat("Citti");
        Cat d = new Cat("Donni");
        Cat e = new Cat("Entoni");
        Cat f = new Cat("Foxi");
        Cat g = new Cat("Goppi");
        Cat h = new Cat("Harolyd");
        Cat i = new Cat("Ivo");
        Cat j = new Cat("Jonni");
        map.put(a.name, a);
        map.put(b.name, b);
        map.put(c.name, c);
        map.put(d.name, d);
        map.put(e.name, e);
        map.put(f.name, f);
        map.put(g.name, g);
        map.put(h.name, h);
        map.put(i.name, i);
        map.put(j.name, j);

        return  map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> mset = new HashSet<Cat>();
        for (Map.Entry<String, Cat> en : map.entrySet())
        {
            mset.add(en.getValue());
        }
        return mset;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
