package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human Jon = new Human("Jon", true, 74, null, null);
        Human Bob = new Human("Bob", true, 65, null, null);
        Human Emma = new Human("Emma", false, 70, null, null);
        Human Olya = new Human("Olyga", false, 66, null, null);
        Human Ivan = new Human("Ivan", true, 33, Bob, Olya);
        Human Jesi = new Human("Jesika", false, 39, Jon, Emma);
        Human Toni = new Human("Toni", true, 15, Ivan, Jesi);
        Human Ira = new Human("Irina", false, 9, Ivan, Jesi);
        Human Igor = new Human("Igor", true, 5, Ivan, Jesi);
        Human[] fam = {Jon,Bob,Emma,Olya,Igor,Ira,Ivan,Jesi,Toni};
        for (int i=0; i<fam.length;i++)
        {
            System.out.println(fam[i].toString());
        }
        //System.out.println(Jon.toString());
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;

        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
