package org.example;
import java.io.*;


public class ShowFile {
    public static void main(String[] args)  {
    int i = 55;
    double d = 0.1;
    double dd=0;
    boolean bool = false;

    try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("myf.txt"))){
        System.out.println("запись d = "+d);
        dos.writeDouble(d);

    }catch (IOException e){
        System.out.println(e);
    }


        try (DataInputStream dis = new DataInputStream(new FileInputStream("myf.txt"))){

           dd = dis.readDouble();

        }catch (IOException e){
            System.out.println(e);
            System.out.println(e);
        }
        System.out.println("считать dd = "+ dd);


    }
}
