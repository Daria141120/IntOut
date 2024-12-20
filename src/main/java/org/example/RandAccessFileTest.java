package org.example;
import java.io.*;

public class RandAccessFileTest {
    public static void main (String args[]){
     double [] masdouble = {19.4, 10.1, 123.54, 33.0, 7.03, 500.1};
     int count = 0;
        if (args.length != 1)
            System.out.println("enter file name ");
/*
     try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(args[0]))){
         for (int i = 0; i < masdouble.length; i++){
             System.out.print(" "+masdouble[i]);
             dos.writeDouble(masdouble[i]);
             count++;
         }
     } catch (IOException e) {
         throw new RuntimeException(e);
     }
*/

     try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")){
         for (int i = 0; i < masdouble.length; i++){
            System.out.print(" "+masdouble[i]);
            raf.writeDouble(masdouble[i]);
         }
         System.out.println();
         raf.seek(0);
         System.out.print(" "+raf.readDouble());
         for (int i = 1; i< masdouble.length; i++){
             raf.seek(8 * i);
             System.out.print(" "+raf.readDouble());

         }

     } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
     } catch (IOException e) {
         throw new RuntimeException(e);
     }
        System.out.println();
     char [] maschar = {'a','b','c'} ;

        try (RandomAccessFile raf2 = new RandomAccessFile(args[0], "rw")){
            for (int i = 0; i < maschar.length; i++){
                System.out.print(" "+maschar[i]);
                raf2.writeChar(maschar[i]);
            }
            System.out.println();

            for (int i = 0; i< maschar.length; i+=2){
                raf2.seek(2 * i);
                System.out.print(" "+ raf2.readChar());

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
