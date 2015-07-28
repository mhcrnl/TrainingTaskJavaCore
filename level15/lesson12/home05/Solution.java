package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution (String s){}
    public Solution (Integer i){}
    public Solution(Object o){}

    private Solution(Exception c){}
    private Solution(Boolean d){}
    private Solution(Float b){}

    protected Solution(Long l){}
    protected Solution(Double s){}
    protected Solution(Character n){}

    Solution (String s, int i){}
    Solution (Integer i, Long l){}
    Solution (Object o, Double d){}
}

