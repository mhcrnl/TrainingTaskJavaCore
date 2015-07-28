package com.javarush.test.level08.lesson11.home02;

import org.omg.CORBA.*;

import java.lang.Object;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        Set<Cat> result = new HashSet<Cat>();

        result.add(new Cat("Jon"));
        result.add(new Cat("Sam"));
        result.add(new Cat("Tom"));
        result.add(new Cat("Bob"));

        return result;
    }

    public static Set<Dog> createDogs()
    {
        Set<Dog> result = new HashSet<Dog>();

        result.add(new Dog("Spark"));
        result.add(new Dog("Mayk"));
        result.add(new Dog("Collins"));

        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        Set<Object> pets = new HashSet<Object>(cats);
        pets.addAll(dogs);
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        Iterator<Object> it = pets.iterator();
        while (it.hasNext())
        {
            Object q = it.next();
            Iterator<Cat> itc = cats.iterator();
            while (itc.hasNext())
            {
                Cat w = itc.next();
                if (q.equals(w)) it.remove();
            }
        }
    }

    public static void printPets(Set<Object> pets)
    {
        Iterator<Object> it = pets.iterator();
        while (it.hasNext()) System.out.println(it.next());
    }

    public static class Cat
    {
        String name;
        Cat(String name)
        {
            this.name = name;
        }
    }

    public static class Dog
    {
        String name;
        Dog(String name)
        {
            this.name = name;
        }
    }
}
