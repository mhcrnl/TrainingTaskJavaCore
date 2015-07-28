package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

import java.util.IllegalFormatException;

/**
 * Created by alexey on 11.06.15.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes type){
        ImageReader ImR;

        if (type == ImageTypes.BMP) ImR = new BmpReader();
        else if (type == ImageTypes.JPG) ImR = new JpgReader();
        else if (type == ImageTypes.PNG) ImR = new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");

        return ImR;
    }
}
