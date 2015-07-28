package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);
        Cat tomcat = new Cat("Tom", "blue", 11);
        Dog spaykdog = new Dog("Spayk","braun",17);

        //Напишите тут ваш код
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }
    public static class Cat
    {
        String name,color;
        int height;
        public Cat(String name, String color, int height)
        {
            this.name=name;
            this.color=color;
            this.height=height;
        }
    }
    public static class Dog
    {
        String name,color;
        int height;
        public Dog(String name, String color, int height)
        {
            this.name=name;
            this.color=color;
            this.height=height;
        }
    }

    //Напишите тут ваши классы

}
