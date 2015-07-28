package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        TreeMap<Integer, FileInputStream> fislist = new TreeMap<Integer, FileInputStream>();
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String sfc = buf.readLine();
        int i1 = sfc.lastIndexOf(".part");
        String name = sfc.substring(0,i1);
        while (!sfc.equals("end")){
            String sp = sfc.substring(i1+5);
            Integer p = Integer.parseInt(sp);
            fislist.put(p,new FileInputStream(sfc));
            sfc=buf.readLine();
        }
        File file=new File(name);
        FileOutputStream fr = new FileOutputStream(file.getAbsolutePath());
        for (Map.Entry<Integer, FileInputStream> m : fislist.entrySet()){
            FileInputStream fis = m.getValue();
            byte[] b = new byte[fis.available()];
            while (fis.available()>0)
            {
                fis.read(b);
                fr.write(b);
            }
        }
        fr.close();

        for (Map.Entry<Integer, FileInputStream> m : fislist.entrySet()) {
            m.getValue().close();
        }
    }
}
