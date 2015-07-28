package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bur = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(bur.readLine());
        StringBuilder s = new StringBuilder();
        FileOutputStream fos = new FileOutputStream(bur.readLine());
        while (fis.available()>=0){
            int c = fis.read();
            if (c == 32) {
                String ns = Math.round(Double.parseDouble(s.toString()))+" ";
                byte[] bs = ns.getBytes();
                fos.write(bs);
                s.delete(0,s.length());
                continue;
            }
            else if (c<=0){
                String ns = Math.round(Double.parseDouble(s.toString()))+" ";
                byte[] bs = ns.getBytes();
                fos.write(bs);
                break;
            }
            else {
                s.append((char)c);
            }
        }
        fis.close();
        fos.close();
        bur.close();

    }
}
