package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args)
    {
        String tagStart = args[0];
        String tagFinish = "/" + args[0] + ">";

        BufferedReader bur = null;
        BufferedReader fr = null;
        try
        {
            bur = new BufferedReader(new InputStreamReader(System.in));
            String fName = bur.readLine();
            bur.close();

            ArrayList<String[]> arrayList = new ArrayList<String[]>();
            fr = new BufferedReader(new FileReader(fName));
            while (fr.ready())
            {
                arrayList.add(fr.readLine().split("<"));
            }
            fr.close();

            ArrayList<Tag> tagList = new ArrayList<Tag>();

            for (String[] sa : arrayList)
            {
                for (int i = 0; i < sa.length; i++)
                {
                    if (sa[i].contains(tagStart) && sa[i].indexOf(tagStart) == 0)
                    {
                        tagList.add(new Tag());
                        for (Tag tag : tagList) if (tag.status) tag.add("<" + sa[i]);
                    } else if (sa[i].contains(tagFinish) && sa[i].indexOf(tagFinish) == 0)
                    {
                        for (Tag tag : tagList) if (tag.status) tag.add("<" + tagFinish);
                        for (int j=1; j<=tagList.size(); j++ )
                        {
                            if (!tagList.get(tagList.size() - j).status) continue;
                                else
                            {
                                tagList.get(tagList.size() - j).setStatus();
                                break;
                            }
                        }
                    } else if (!tagList.isEmpty() && i!=0) for (Tag tag : tagList) {
                        if (tag.status) tag.add("<" + sa[i]);
                    }
                    else for (Tag tag : tagList) if (tag.status) tag.add(sa[i]);
                }

            }
            for (Tag tag : tagList) System.out.println(tag.getTag());
        } catch (Exception e) {}
        finally
        {
            try
            {
                if (bur != null) bur.close();
                if (fr != null) fr.close();
            } catch (IOException e){}
        }
    }

    public static class Tag{

        boolean status = true;
        StringBuilder tagBody = new StringBuilder("");

        Tag(){
        }

        public void add(String s){
            tagBody.append(s);
        }

        public String getTag(){
            return this.tagBody.toString();
        }

        public void setStatus(){
            this.status=!this.status;
        }
    }
}
