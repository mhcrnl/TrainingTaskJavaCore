package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bur = new BufferedReader(new InputStreamReader(System.in));
        String name = bur.readLine();
        bur.close();
        if (args[0].equals("-c"))
        {
            ArrayList<Integer> pl = new ArrayList<Integer>();
            BufferedReader buf = new BufferedReader(new FileReader(name));
            String s = buf.readLine();
            while (s != null)
            {
                int a = s.substring(0, 8).indexOf(" ");
                if (a < 0) pl.add(Integer.parseInt(s.substring(0, 8)));
                else pl.add(Integer.parseInt(s.substring(0, s.substring(0, 8).indexOf(" "))));
                s = buf.readLine();
            }
            buf.close();
            int max = pl.get(0);
            for (Integer i : pl)
            {
                if (i > max) max = i;
            }
            String m = String.valueOf(max+1);
            while (m.length() < 8) m = m+" ";
            BufferedWriter buw = new BufferedWriter(new FileWriter(name,true));
            String pn=args[1], pr=args[2], qu=args[3];
            if (pn.length()<=30) while (pn.length()<30) pn+=" ";
            else pn=pn.substring(0,30);
            if (pr.length()<=8) while (pr.length()<8) pr+=" ";
            else pr=pr.substring(0,8);
            if (qu.length()<=4) while (qu.length()<4) qu+=" ";
            else qu=qu.substring(0,4);
            String str = m+pn+pr+qu;
            buw.write(str);
            buw.close();
        }
    }
}
