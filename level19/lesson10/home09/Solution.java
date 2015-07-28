package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try{
            PrintStream cOut = System.out;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream bOut = new PrintStream(baos);
            System.setOut(bOut);
            testString.printSomething();
            System.setOut(cOut);
            String[] b = baos.toString().split("\\n");
            for (int i=0; i<b.length; i+=2){
                System.out.println(b[i]);
                System.out.println(b[i+1]);
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }catch(Exception e){}
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
