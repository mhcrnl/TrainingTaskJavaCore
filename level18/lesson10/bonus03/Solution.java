package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufer.readLine();
        TreeMap<Integer, String> pt = treeCreator(fileName);
        if (args[0].equals("-d")) pt.remove(Integer.parseInt(args[1]));
        else if (args[0].equals("-u")) {
            int id = Integer.parseInt(args[1]);
            pt.put(Integer.parseInt(args[1]), makeInfo(args[2],args[3],args[4]));
        }
        rewrite(pt,fileName);
        bufer.close();
    }

    public static TreeMap<Integer, String> treeCreator(String file) throws IOException{
        TreeMap<Integer, String> prodtree = new TreeMap<Integer, String>();
        BufferedReader buf = new BufferedReader(new FileReader(file));
        String s = buf.readLine();
        while (s != null)
        {
            int a = s.substring(0, 8).indexOf(" ");
            if (a < 0) prodtree.put(Integer.parseInt(s.substring(0, 8)), s.substring(8));
            else prodtree.put(Integer.parseInt(s.substring(0, a)), s.substring(8));
            s = buf.readLine();
        }
        buf.close();
        return prodtree;
    }

    public static String makeLine(int i, String info){
        String id = String.valueOf(i);
        if (id.length()<=8) while (id.length()<8) id+=" ";
        String st = id+info;
        return st;
    }

    public static String makeInfo(String pn, String pr, String qu){
        String res = null;
        if (pn.length()<=30) while (pn.length()<30) pn+=" ";
        else pn=pn.substring(0,30);
        if (pr.length()<=8) while (pr.length()<8) pr+=" ";
        else pr=pr.substring(0,8);
        if (qu.length()<=4) while (qu.length()<4) qu+=" ";
        else qu=qu.substring(0,4);
        res = pn+pr+qu;
        return res;
    }

    public static void rewrite(TreeMap<Integer,String> tm, String file) throws IOException {
        BufferedWriter buw = new BufferedWriter(new FileWriter(file));
        for (Map.Entry<Integer,String> me : tm.entrySet()){
            String toW = makeLine(me.getKey(), me.getValue());
            buw.write(toW);
            buw.newLine();
        }
        buw.close();
    }
}
