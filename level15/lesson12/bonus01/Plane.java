package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by alexey on 02.06.15.
 */
public class Plane implements Flyable
{
    int passCount;
    Plane (int passCount)
    {
        this.passCount = passCount;
    }

    @Override
    public void fly()
    {

    }
}
