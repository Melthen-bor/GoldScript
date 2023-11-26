import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class interpreter{
  public static String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public static void interpreter(String file_name){
    try{
      String fileName = concate(file_name,".gd");
      File_reader fileHandler = new File_reader(fileName);
      String[] contents = fileHandler.read();
      int a = 1;
      int b = 0;
      while(a==1){
        try{
          
        } catch(Exception e){
          a = 0;
        }
      }
    } catch(Exception e){
      System.println("\033[31mError[0]:Critical failure\033[0m");
    }
  }
}
