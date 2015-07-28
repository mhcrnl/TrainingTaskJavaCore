package com.javarush.test.level11.lesson11.bonus03;

/* Задача по алгоритмам
Написать метод, который возвращает минимальное и максимальное числа в массиве.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return new Pair<Integer, Integer>(null, null);
        }

        return new Pair<Integer, Integer>(min(array), max(array));
    }

    public static int max(int[] array)
    {
        int max = array[0];
        for (int i=1; i<array.length; i++)
        {
            if (array[i]>max) max=array[i];
        }
        return max;
    }

    public static int min(int[] array)
    {
        int min = array[0];
        for (int i=1; i<array.length; i++)
        {
            if (array[i]<min) min=array[i];
        }
        return min;
    }

    public static class Pair<X, Y>
    {
        public X x;
        public Y y;

        public Pair(X x, Y y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
