//package gold;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class file_reader{
  File file;
  public file_reader(String file_name){
    String fileName = file_name;
    file = new File(fileName);
  }
  public ArrayList read(){
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
  public void change(String file_name){
    file = new File(file_name);
  }
}
