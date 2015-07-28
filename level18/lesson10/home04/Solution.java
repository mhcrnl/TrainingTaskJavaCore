package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bur = new BufferedReader(new InputStreamReader(System.in));
        String fo = bur.readLine();
        String ft = bur.readLine();
        FileInputStream fis = new FileInputStream(ft);
        FileInputStream fiss = new FileInputStream(fo);
        byte[] fob = new byte[fiss.available()];
        fiss.read(fob);
        FileOutputStream fos = new FileOutputStream(fo);
        byte[] ftb = new byte[fis.available()];
        fis.read(ftb);
        fos.write(ftb);
        fos.write(fob);
        fis.close();
        fos.close();
    }
}
