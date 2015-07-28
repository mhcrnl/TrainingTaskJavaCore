package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: маму, папу, сына, дочь, бабушку(мамина мама) и дедушку(папин папа).
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String gfatherName = reader.readLine();
        Cat catGfather = new Cat(gfatherName);

        String gmotherName = reader.readLine();
        Cat catGmother = new Cat(gmotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, catGfather, null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, null, catGmother);

        String sunName = reader.readLine();
        Cat catSun = new Cat(sunName, catFather, catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catFather,catMother);

        System.out.println(catGfather.toString());
        System.out.println(catGmother.toString());
        System.out.println(catFather.toString());
        System.out.println(catMother.toString());
        System.out.println(catSun.toString());
        System.out.println(catDaughter.toString());
    }

    public static class Cat
    {
        private String name;
        private Cat parentf, parentm;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat parentf)
        {
            this.name = name;
            this.parentf = parentf;
        }

        Cat(String name, Cat parentf, Cat parentm)
        {
            this.name = name;
            this.parentf = parentf;
            this.parentm = parentm;
        }

        @Override
        public String toString()
        {
            if (parentf == null && parentm == null)
                return "Cat name is " + name + ", no mother, no father";
            else if (parentf == null && parentm != null)
                return "Cat name is " + name + ", mother is " + parentm.name + ", no father";
            else if (parentf != null && parentm == null)
                return "Cat name is " + name + ", no mother, father is " + parentf.name;
            else //if (parentf != null && parentm != null)
                return "Cat name is " + name + ", mother is " + parentm.name + ", father is " + parentf.name;
        }
    }

}
