package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String first_name;
        String second_name;
        int age;
        boolean sex;
        boolean children;
        String job;

        Human (String fname, boolean sex)
        {
            first_name = fname;
            this.sex = sex;
        }
        Human (String sname)
        {
            second_name = sname;
        }
        Human (int age, boolean sex)
        {
            this.age = age;
            this.sex = sex;
        }
        Human (String fname, String sname, int age)
        {
            first_name = fname;
            second_name = sname;
            this.age = age;
        }
        Human (String fname, String sname, boolean sex)
        {
            first_name = fname;
            second_name = sname;
            this.sex = sex;
        }
        Human (String sname, boolean sex, boolean children)
        {
            second_name = sname;
            this.sex = sex;
            this.children = children;
        }
        Human (String sname, String job)
        {
            second_name = sname;
            this.job = job;
        }
        Human (String fname, String sname, String job)
        {
            first_name = fname;
            second_name = sname;
            this.job = job;
        }
        Human (String fname, String sname, int age, boolean sex, String job)
        {
            first_name = fname;
            second_name = sname;
            this.age = age;
            this.sex = sex;
            this.job = job;
        }
        Human (String fname, String sname, int age, boolean sex, String job, boolean ch)
        {
            first_name = fname;
            second_name = sname;
            this.age = age;
            this.sex = sex;
            this.job = job;
            children = ch;
        }


    }
}
