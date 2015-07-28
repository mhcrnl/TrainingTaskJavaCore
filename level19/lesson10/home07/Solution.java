package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;



public class Solution {
    public static void main(String[] args) {
        BufferedReader bur=null;
        BufferedWriter buw=null;
        ArrayList<String> list = new ArrayList<String>();
        try{
            bur=new BufferedReader(new FileReader(args[0]));
            buw=new BufferedWriter(new FileWriter(args[1]));
            while (bur.ready()){
                String[] sa=bur.readLine().split(" ");
                for (String s : sa){
                    if (s.length()>6) list.add(s);
                }
            }
            for (int i=0; i<list.size()-1;i++){
                buw.write(list.get(i) + ",");
            }
            buw.write(list.get(list.size()-1));
        }catch(Exception e){}
        finally
        {
            try{
                if (bur!=null) bur.close();
                if (buw!=null) buw.close();
            }catch(Exception e){}
        }

    }
}
