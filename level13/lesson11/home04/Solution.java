package com.javarush.test.level13.lesson11.home04;

import java.io.*;
import java.util.*;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bur = new BufferedReader(new InputStreamReader(System.in));
        String name = bur.readLine();
        OutputStream outputStream = new FileOutputStream(name);
        while (true)
        {
            String a = bur.readLine();
            if (a.equals("exit"))
            {
                outputStream.write((a + "\r\n").getBytes());
                break;
            }
            else
            {
                outputStream.write((a + "\r\n").getBytes());
            }
        }
        outputStream.close();
        bur.close();

    }
}
