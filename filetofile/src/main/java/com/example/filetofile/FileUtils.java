package com.example.filetofile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public static void writeFile(String path,String content) {
        BufferedWriter bufferedWriter = null;
        try{
            bufferedWriter = new BufferedWriter(new FileWriter(path));
            bufferedWriter.write(content);
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally {
            if(bufferedWriter != null)
            {
                try {
                    bufferedWriter.close();
                }catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static String readFile(String path) {
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader(path));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) !=null)
            {
                sb.append(line);
            }
            return sb.toString();
        }catch (IOException ex)
        {
            ex.printStackTrace();

        }finally {
            if(bufferedReader != null)
            {
                try
                {
                    bufferedReader.close();
                }catch (IOException ex)
                {
                    ex.printStackTrace();
                }

            }
        }
        return null;
    }
}
