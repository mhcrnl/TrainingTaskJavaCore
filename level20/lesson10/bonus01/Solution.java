package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static void main(String[] args)
    {

        for (int i : getNumbers(147467259)) System.out.println(i);

    }

    public static int[] getNumbers(int N) {
        int[] result = null;

        ArrayList<Integer> listOfNarcissisticNumbers = new ArrayList<Integer>();

        for (int i=1; i<=N; i++){
            int Nc = 1;
            int newN = i/10;
            while (newN>0){
                Nc++;
                newN=newN/10;
            }

            int sum = 0;
            int r = i;
            while (r>0){
                sum+=pow(r%10,Nc);
                r=r/10;
            }

            if (sum==i) listOfNarcissisticNumbers.add(i);
        }

        result = new int[listOfNarcissisticNumbers.size()];
        for (int i=0; i<listOfNarcissisticNumbers.size();i++) {
            result[i] = listOfNarcissisticNumbers.get(i);
        }

        return result;
    }

    public static int pow(int a, int b){
        int q =1;
        for(int i=1; i<=b; i++) q*=a;
        return q;
    }
}
