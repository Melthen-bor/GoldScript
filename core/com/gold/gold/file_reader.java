//package gold;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class file_reader{
  static File file;
  public static file_reader(static String file_name){
    static String fileName = file_name;
    file = new File(fileName);
  }
  public static List read(){
    ArrayList<String> out = new ArrayList<String>();
    int a = 1;
    String temp;
    Scanner fileHandler = new Scanner(file);
    while(a==1){
      try{
        temp = fileHandler.nextLine();
        out.add(temp);
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
