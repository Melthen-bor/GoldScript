import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Gold{
  public static String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public static void main(String[] args){
    String file = args[0];
    String[] intargs = args[1].split("\[split\]");
    interpreter int = new interpreter();
    int.run(args[2]);
  }
}