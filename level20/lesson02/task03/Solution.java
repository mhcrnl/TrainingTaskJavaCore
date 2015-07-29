package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/**
 * Created by alexey on 29.07.15.
 */

public class Solution
{
    public static Map<String, String> properties = new HashMap<String, String>();

    public static void main(String[] args) throws Exception
    {
        Solution sol = new Solution();
        sol.fillInPropertiesMap();
        System.out.println(properties.toString());

        File newFile = new File("/home/alexey/pro/map.txt");
        OutputStream os = new FileOutputStream(newFile);
        sol.save(os);
        os.close();
    }

    public void fillInPropertiesMap(){

        BufferedReader bur = null;
        InputStream fis = null;

        try
        {
            bur = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bur.readLine();
            bur.close();

            fis = new FileInputStream(fileName);
            load(fis);

        }
        catch (Exception e){}
        finally
        {
            try{
                if (bur!=null) bur.close();
                if (fis!=null) fis.close();
            }catch(Exception e) {}
        }


    }

    public void save(OutputStream outputStream) throws Exception{
        Properties prop = new Properties();
        for (Map.Entry<String, String> me : properties.entrySet())
            prop.put(me.getKey(), me.getValue());
        prop.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception{
        BufferedReader bufer = new BufferedReader(new InputStreamReader(inputStream));
        Properties prop = new Properties();
        prop.load(bufer);

        for (Map.Entry<Object, Object> map : prop.entrySet()){
            properties.put(map.getKey().toString(), map.getValue().toString());
        }

    }
}

