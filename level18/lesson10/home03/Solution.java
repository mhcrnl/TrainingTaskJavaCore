package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = buf.readLine();
        String nameTwo = buf.readLine();
        String nameThree = buf.readLine();
        FileInputStream fileTwo = new FileInputStream(nameTwo);
        FileInputStream fileThree = new FileInputStream(nameThree);
        FileOutputStream fileOne = new FileOutputStream(nameOne);
        while (fileTwo.available()>0){
            fileOne.write(fileTwo.read());
        }
        while (fileThree.available()>0){
            fileOne.write(fileThree.read());
        }
        fileOne.close();
        fileThree.close();
        fileTwo.close();

    }
}
