import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class interpreter{
  public static String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public static void interpreter(String file_name){
    String fileName = concate(file_name,".gd");
    File_reader fileHandler = new File_reader(fileName);
  }
}
