package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/


import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buR = new BufferedReader(new InputStreamReader(System.in));
        String name = buR.readLine();

        InputStream fin = new FileInputStream(name);
        while(fin.available()>0)
        {
            System.out.print( (char) fin.read());
        }

        fin.close();
        buR.close();
    }
}
