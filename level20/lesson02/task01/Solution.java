package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
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

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);

            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(somePerson.name);
            for (Asset a : somePerson.assets) System.out.println(a.getName());
            System.out.println();
            System.out.println(ivanov.name);
            for (Asset a : ivanov.assets) System.out.println(a.getName());
            inputStream.close();

        } catch (IOException e) {
            System.out.println("Oops, something wrong with my file");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Oops, something wrong with save/load method");
            e.printStackTrace();
        }
    }


    public static class Human{
        public String name;
        public List<Asset> assets = new ArrayList<Asset>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter pW = new PrintWriter(outputStream);
            pW.println("NewHuman");
            pW.println(name);
            for (Asset as : assets){
                pW.println(as.getName());
                pW.println(as.getPrice());
            }
            pW.println("the end");
            pW.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bur = new BufferedReader(new InputStreamReader(inputStream));
            if (bur.readLine().equals("NewHuman")){
                name = bur.readLine();
                String next;
                while(bur.ready() && !(next=bur.readLine()).equals("the end")){
                    Asset asset = new Asset(next);
                    asset.setPrice(Double.parseDouble(bur.readLine()));
                    assets.add(asset);
                }
            }
            bur.close();
        }
    }
}
