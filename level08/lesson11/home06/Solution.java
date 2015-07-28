package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Iterator;

public class Solution
{
    public static void main(String[] args)
    {
        Human Judi = new Human("Judi", false, 15, new ArrayList<Human>());
        Human Jon = new Human("Jonatan", true, 10, new ArrayList<Human>());
        Human Jack = new Human("Jack", true, 7, new ArrayList<Human>());
        ArrayList<Human> children = new ArrayList<Human>();
        children.add(Judi);
        children.add(Jon);
        children.add(Jack);

        Human father = new Human("Pol", true, 44, children);
        Human mother = new Human("Elena", false, 40, children);

        ArrayList<Human> f1 = new ArrayList<Human>();
        f1.add(father);
        ArrayList<Human> f2 = new ArrayList<Human>();
        f2.add(mother);

        Human gm1 = new Human("Koni", false, 70, f1);
        Human gf1 = new Human("Bob", true, 72, f1);
        Human gm2 = new Human("Kristi", false, 65, f2);
        Human gf2 = new Human("Jon", true, 66, f2);

        ArrayList<Human> family = new ArrayList<Human>();
        family.addAll(children);
        family.add(father);
        family.add(mother);
        family.add(gm1);
        family.add(gf1);
        family.add(gm2);
        family.add(gf2);

        System.out.println(gm1.toString());
        System.out.println(gf1.toString());
        System.out.println(gm2.toString());
        System.out.println(gf2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(Jack.toString());
        System.out.println(Jon.toString());
        System.out.println(Judi.toString());
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();
        Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.children=children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }

    }

}
