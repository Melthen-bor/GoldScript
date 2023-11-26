import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
public class file_reader{
  public static void file_reader(String file_name){
    File file = new File(file_name);
  }
  public static String read(){
    String out;
    out = Files.readString(file);
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
