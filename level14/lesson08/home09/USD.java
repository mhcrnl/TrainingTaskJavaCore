package com.javarush.test.level14.lesson08.home09;

/**
 * Created by alexey on 25.05.15.
 */
public class USD extends Money
{
    USD (double amount)
    {
        super(amount);
    }
    public String getCurrencyName(){
        return "USD";
    }
}
