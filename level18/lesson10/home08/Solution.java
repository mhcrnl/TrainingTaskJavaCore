package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        ArrayList<String> thlist = new ArrayList<String>();
        BufferedReader bur = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String w = bur.readLine();
            while (!w.equals("exit"))
            {
                thlist.add(w);
                w = bur.readLine();
            }
            for (String t : thlist) {
                ReadThread rs = new ReadThread(t);
                rs.start();
                rs.join();
            }
            bur.close();
        } catch (Exception e){}
    }

    public static class ReadThread extends Thread {
        int[] ba = new int[256];
        String file =new String();
        public ReadThread(String fileName) {
            this.file = fileName;
        }

        @Override
        public void run()
        {
            try
            {
                FileInputStream fis = new FileInputStream(file);
                while (fis.available()>0)
                {
                    ba[fis.read()]++;
                }
                fis.close();
                int max = ba[0];
                int maxb = 0;
                for (int i=1; i<256; i++){
                    if (ba[i]>=max) {
                        max=ba[i];
                        maxb=i;
                    }
                }

                resultMap.put(file, maxb);
            }
            catch (Exception e) {}
        }
    }
}
