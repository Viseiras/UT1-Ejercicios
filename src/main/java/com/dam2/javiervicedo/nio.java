package com.dam2.javiervicedo;

import java.nio.*;
import  java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class nio {
    public static void copia() throws IOException{
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el fichero que deseas copiar:\n");
        String file=sc.nextLine();
        System.out.println("Introduce el nombre al que quieres cambiar el archivo:\n");
        String rename= sc.nextLine();

        copiar(file,rename);

    }

    public static void copiar(String file, String rename)
    {
        try (RandomAccessFile raf = new RandomAccessFile(file,"rw");FileChannel fileChannelReader = raf.getChannel();){


            ByteBuffer byteBuffer = ByteBuffer.allocate(1042);
            Path copied = Paths.get(rename);

            Set<StandardOpenOption> options = new HashSet<>();
            options.add(StandardOpenOption.CREATE);
            options.add(StandardOpenOption.APPEND);

            FileChannel fileChannelWriter = FileChannel.open(copied,options);

            while(fileChannelReader.read(byteBuffer)>0)
            {
                byteBuffer.flip();
                fileChannelWriter.write(byteBuffer);
            }

            fileChannelWriter.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
