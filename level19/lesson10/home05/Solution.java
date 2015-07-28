package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bur=null;
        BufferedWriter buw=null;
        try{
            bur = new BufferedReader(new FileReader(args[0]));
            buw = new BufferedWriter(new FileWriter(args[1]));
            Pattern pat = Pattern.compile("\\d");
            while (bur.ready())
            {
                String[] fla = bur.readLine().split(" ");
                for (String s : fla)
                {
                    Matcher m = pat.matcher(s);
                    if (m.find())
                    {
                        buw.write(s + " ");
                    }
                }
            }
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
