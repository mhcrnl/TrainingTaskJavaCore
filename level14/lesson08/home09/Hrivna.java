package com.javarush.test.level14.lesson08.home09;

/**
 * Created by alexey on 25.05.15.
 */
public class Hrivna extends Money
{
    Hrivna (double amount)
    {
        super(amount);
    }
    public String getCurrencyName(){
        return "HRN";
    }
}
