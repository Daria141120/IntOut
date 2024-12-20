package org.example;
import java.io.*;

import static java.lang.Math.abs;


public class ShowFile {


    public static void main(String[] args)  {
        int i = 0, j = 0;
        int count = 0;
        if (args.length != 2)
            System.out.println("enter names two files");

        try (var fin1 = new FileInputStream(args [0]) ; var fin2 = new FileInputStream(args[1])) {
            do {
                i = fin1.read();
                j = fin2.read();
                System.out.println("i = "+ i + " j = "+ j);
                if (!( abs(i - j) == 32 || i - j == 0 ))
             //   if (i != j)
                    break;
                count++;
            }while (i != -1  &&  j != -1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (i != j)
            System.out.println("file different sinse : " + count);
        else
            System.out.println("files similar");


    }
}
