package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int rec=0;
        int len = a[0].length;
        for (int i=1; i<a.length-1; i++){
            for (int j=0; j<len; j++) {
                if (a[i - 1][j]!=a[i][j] && a[i-1][j]==1) count++;
                else if (count>0) {
                    rec++;
                    count=0;
                }
            }
            if (count>0) {
                rec++;
                count=0;
            }
        }
        for (int j=0; j<len; j++){
            if (a[a.length-2][j]==a[a.length-1][j]){
                if (a[a.length-1][j]==1) count++;
                else if (count>0) {
                    rec++;
                    count=0;
                }
            }
            else count++;
        }
        if (count>0) rec++;
        return rec;
    }
}
