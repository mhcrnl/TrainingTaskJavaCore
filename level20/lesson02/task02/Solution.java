package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("/home/alexey/pro/out");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            User u1 = new User();
            User u2 = new User();
            u1.setCountry(User.Country.UKRAINE);
            u2.setCountry(User.Country.OTHER);
            u1.setBirthDate(new GregorianCalendar(1991, 2, 21).getTime());
            u2.setBirthDate(new GregorianCalendar(1990, 11, 7).getTime());
            u1.setFirstName("Antonio");
            u2.setFirstName("Joni");
            u1.setLastName("Kokovetzh");
            u2.setLastName("Pakolonetzh");
            u1.setMale(true);
            u2.setMale(true);
            JavaRush javaRush = new JavaRush();
            javaRush.users.add(u1);
            javaRush.users.add(u2);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            Comparator<List<User>> c = new Comparator<List<User>>()
            {
                @Override
                public int compare(List<User> u1, List<User> u2)
                {
                    int c=0;
                    if (u1.size()==u2.size())
                        for (int i=0; i< u1.size(); i++){
                            if (u1.get(i).getBirthDate().equals(u2.get(i).getBirthDate())) c++;
                            if (u1.get(i).getCountry().equals(u2.get(i).getCountry())) c++;
                            if (u1.get(i).getFirstName().equals(u2.get(i).getFirstName())) c++;
                            if (u1.get(i).getLastName().equals(u2.get(i).getLastName())) c++;
                            if (u1.get(i).isMale() == u2.get(i).isMale()) c++;
                        }
                    return c;
                }
            };

            if (c.compare(javaRush.users,loadedObject.users)==javaRush.users.size()*5) System.out.println("OK");
            else System.out.println("NOT");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<User>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter pw = new PrintWriter(outputStream);
            for (User us : users){
                pw.println(us.getFirstName());
                pw.println(us.getLastName());
                pw.println(us.getBirthDate().getTime());
                pw.println(us.isMale());
                pw.println(us.getCountry().toString());
            }
            pw.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bur = new BufferedReader(new InputStreamReader(inputStream));
            while (bur.ready()){
                User user = new User();
                user.setFirstName(bur.readLine());
                user.setLastName(bur.readLine());
                user.setBirthDate(new Date(Long.parseLong(bur.readLine())));
                user.setMale(Boolean.parseBoolean(bur.readLine()));
                user.setCountry(User.Country.valueOf(bur.readLine()));
                users.add(user);
            }
            bur.close();
        }
    }
}
