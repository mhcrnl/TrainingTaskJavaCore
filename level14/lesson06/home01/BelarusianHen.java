package com.javarush.test.level14.lesson06.home01;

/**
 * Created by alexey on 25.05.15.
 */
public class BelarusianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 24;
    }
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " +this.getCountOfEggsPerMonth() +
                " яиц в месяц.";
    }
}
