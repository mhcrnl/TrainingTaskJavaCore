package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        if (args[0].equals("-e")){
            FileInputStream fn = new FileInputStream(args[1]);
            FileOutputStream fon = new FileOutputStream(args[2]);
            while (fn.available()>0){
                int c = fn.read();
                if (c<127) fon.write(c+129);
                else if (c==127 || c==128) fon.write(c);
                else fon.write(c-129);
            }
            fn.close();
            fon.close();
        } else if (args[0].equals("-d")){
            FileInputStream fn = new FileInputStream(args[1]);
            FileOutputStream fon = new FileOutputStream(args[2]);
            while (fn.available()>0){
                int c = fn.read();
                if (c>128) fon.write(c-129);
                else if (c==127 || c==128) fon.write(c);
                else fon.write(c+129);
            }
            fn.close();
            fon.close();
        }

    }

}
