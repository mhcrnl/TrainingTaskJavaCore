package com.javarush.test.level15.lesson12.home05;

/**
 * Created by alexey on 29.05.15.
 */
public class SubSolution extends Solution
{
    public SubSolution(String s)
    {
        super(s);
    }

    public SubSolution(Integer i)
    {
        super(i);
    }

    public SubSolution(Object o)
    {
        super(o);
    }

    protected SubSolution(Long l)
    {
        super(l);
    }

    protected SubSolution(Double s)
    {
        super(s);
    }

    protected SubSolution(Character n)
    {
        super(n);
    }

    SubSolution(String s, int i)
    {
        super(s, i);
    }

    SubSolution(Integer i, Long l)
    {
        super(i, l);
    }

    SubSolution(Object o, Double d)
    {
        super(o, d);
    }
    private SubSolution(Exception c){
     super(c);
    }
    private SubSolution(Boolean d){
        super(d);
    }
    private SubSolution(Float b){
        super(b);
    }
}
