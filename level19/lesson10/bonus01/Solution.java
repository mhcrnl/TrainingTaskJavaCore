package com.javarush.test.level19.lesson10.bonus01;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - с/писок lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = bufer.readLine();
        String fileTwo = bufer.readLine();
        bufer.close();
        BufferedReader burOne = new BufferedReader(new FileReader(fileOne));
        BufferedReader burTwo = new BufferedReader(new FileReader(fileTwo));
        List<String> fOneL = new ArrayList<String>();
        List<String> fTwoL = new ArrayList<String>();
        while (burOne.ready()) fOneL.add(burOne.readLine());
        while (burTwo.ready()) fTwoL.add(burTwo.readLine());

        if (fOneL.size()>fTwoL.size()) comparator(fTwoL,fOneL,true);
        else comparator(fOneL,fTwoL,false);
    }

    public static void comparator(List<String> fOneL, List<String> fTwoL, boolean fOrS){
        int c=0;
        Type typeOne = null;
        Type typeTwo = null;
        if (fOrS){
            typeOne = Type.REMOVED;
            typeTwo = Type.ADDED;
        }
        else {
            typeOne = Type.ADDED;
            typeTwo = Type.REMOVED;
        }
        for (int i=0; i<fOneL.size(); i++)
            for (int j = c; j < fTwoL.size(); ){
                if (fOneL.get(i).equals(fTwoL.get(j))) {
                    lines.add(new LineItem(Type.SAME, fOneL.get(i)));
                    c++;
                    break;
                }
                else if (fOneL.get(i).equals(fTwoL.get(j+1))){
                    lines.add(new LineItem(typeOne, fTwoL.get(j)));
                    lines.add(new LineItem(Type.SAME, fOneL.get(i)));
                    c+=2;
                    break;
                }
                else {
                    lines.add(new LineItem(typeTwo, fOneL.get(i)));
                    break;
                }
            }
        if (c<fTwoL.size()) lines.add(new LineItem(typeOne, fTwoL.get(c)));
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
