package gold;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class goldExeception{
  public static String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public static void goldExeception(String error,String errortype){
    final String errormessage = concate("\033[31m",concate(error,"\033[0m")));
    final String type = errortype;
  }
  public static String gettype(){
    return type;
  }
  public static String getmessage(){
    return errormessage;
  }
}