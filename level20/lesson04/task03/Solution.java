package com.javarush.test.level20.lesson04.task03;

import java.io.*;

/**
 * Created by alexey on 30.07.15.
 */
public class Solution implements Serializable
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Singleton instance = Singleton.getInstance();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/alexey/pro/singleton.tmp"));
        oos.writeObject(instance);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/alexey/pro/singleton.tmp"));
        Singleton singleton = (Singleton) ois.readObject();
        ois.close();

        ObjectInputStream oiS = new ObjectInputStream(new FileInputStream("/home/alexey/pro/singleton.tmp"));
        Singleton singletonchik = (Singleton) oiS.readObject();
        oiS.close();

        System.out.println("Instance reference check" + singleton.getInstance());
        System.out.println("Instance reference check" + singletonchik.getInstance());
        System.out.println();
        System.out.println("Object reference check" + singleton);
        System.out.println("Object reference check" + singletonchik);
    }

    public static class Singleton implements Serializable{

        private static Singleton ourInstance;

        private Singleton(){

        }

        public static Singleton getInstance(){
            if (ourInstance==null) ourInstance = new Singleton();
            return ourInstance;
        }

        protected Object readResolve() {
            return getInstance();
        }

    }
}
