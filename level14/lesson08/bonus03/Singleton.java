package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by alexey on 25.05.15.
 */
public class Singleton
{
    public static Singleton onlyOne = null;
    private Singleton(){}
    public static Singleton getInstance()
    {
        if (onlyOne == null) onlyOne = new Singleton();
        return onlyOne;
    }
}
