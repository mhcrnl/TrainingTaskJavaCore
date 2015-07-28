package com.javarush.test.level14.lesson06.home01;

/**
 * Created by alexey on 25.05.15.
 */
public class RussianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 23;
    }
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " +this.getCountOfEggsPerMonth() +
                " яиц в месяц.";
    }
}
