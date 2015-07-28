package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufer=null;
        BufferedReader bur=null;
        try{
            bufer = new BufferedReader(new InputStreamReader(System.in));
            String name = bufer.readLine();
            bur=new BufferedReader(new FileReader(name));
            while (bur.ready()){
                String[] sa = bur.readLine().split("");
                for (int i = sa.length-1; i>=0; i--) System.out.print(sa[i]);
                System.out.println("\r");
            }
        }catch(Exception e){}
        finally
        {
            try{
                if (bufer!=null) bufer.close();
                if (bur!=null) bur.close();
            }catch(Exception e){}
        }
    }
}
