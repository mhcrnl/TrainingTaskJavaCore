package com.javarush.test.level20.lesson02.task04;

import java.io.*;

/**
 * Created by alexey on 29.07.15.
 */
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ClassWithStatic cWS = new ClassWithStatic();
        InputStream fis = new FileInputStream("/home/alexey/pro/in.txt");
        cWS.load(fis);

        OutputStream fos = new FileOutputStream(new File("/home/alexey/pro/200204.txt"));
        cWS.save(fos);

        ClassWithStatic cWs = new ClassWithStatic();
        cWs.staticString = "Krokodil";
        cWs.i = 500;
        cWs.j = 40;
        System.out.println(cWs.staticString+cWs.i+cWs.j);
        fis = new FileInputStream("/home/alexey/pro/in.txt");
        cWs.load(fis);

        System.out.println(cWs.staticString+cWs.i+cWs.j);
        fis.close();
        fos.close();
    }
    public static class ClassWithStatic{

        public static String staticString = "Test static string";
        public int i;
        public int j;

        public void save (OutputStream outputStream) throws Exception{
            PrintWriter pW = new PrintWriter(outputStream);
            pW.println(staticString);
            pW.println(String.valueOf(i));
            pW.println(String.valueOf(j));
            pW.close();
        }

        public void load (InputStream inputStream) throws Exception{
            BufferedReader bufer = new BufferedReader(new InputStreamReader(inputStream));
            staticString = bufer.readLine();
            i = Integer.parseInt(bufer.readLine());
            j = Integer.parseInt(bufer.readLine());
            bufer.close();
        }
    }
}
