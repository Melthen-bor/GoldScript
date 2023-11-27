//package com.gold.gold.handlers;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class file_reader{
  public static void file_reader(String file_name){
    String fileName = file_name;
    static File file = new File(fileName);
  }
  public static String[] read(){
    String[] out;
    int a = 1;
    int b = 0;
    String temp;
    Scanner fileHandler = new Scanner(file);
    while(a==1){
      try{
        temp = fileHandler.nextLine();
        out[b] = temp;
        b += 1;
      } catch(Exception e){
        a = 0;
      }
    }
    fileHandler.close();
    return out;
  }
  public static void change(String file_name){
    file.close();
    file = new File(file_name);
  }
  public static void close(){
    file.close();
    file = null;
  }
}
