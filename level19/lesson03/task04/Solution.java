package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scan;
        public PersonScannerAdapter(Scanner scan){
            this.scan=scan;
        }
        public Person read() throws IOException{
                String s = scan.nextLine();
                String[] sa=s.split(" ");
                Calendar cal = new GregorianCalendar(Integer.parseInt(sa[5]), Integer.parseInt(sa[4])-1, Integer.parseInt(sa[3]));
                Date date = cal.getTime();
            Person p = new Person(sa[1],sa[2],sa[0],date);
            return p;
        }

        public void close() throws IOException{
            this.scan.close();
        }

    }
}
