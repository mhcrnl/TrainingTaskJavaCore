package com.javarush.test.level08.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int min = array.get(0);
        for (Integer w : array)
        {
            if (w<min) min=w;
        }
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        List<Integer> listInt = new ArrayList<Integer>();
        for (int i=0; i<n; i++)
        {
            //System.out.println("Print number #" + (i+1));
            int q = Integer.parseInt(buf.readLine());
            listInt.add(q);
        }
        return listInt;
    }
}
