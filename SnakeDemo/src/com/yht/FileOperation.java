package com.yht;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {
    public static File file = new File("你想要存储的位置");

    public static void writeMessage(String message){
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write("");//清空原文件内容
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static String readScore(){
        String result = "";
        if(file.exists()){
            FileReader reader = null;
            try {
                reader = new FileReader(file);
                char [] buf = new char[1024];
                int num = 0;
                while((num = reader.read(buf))!=-1) {
                    result += new String(buf,0,num);
                }
            }catch(IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(reader!=null)
                        reader.close();
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }


}