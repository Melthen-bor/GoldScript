import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class goldExeception{
  public static String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public static void goldExeception(String error,String errortype){
    private final String errormessage = concate("\033[31m",conacte(error,"\033[0m")));
    private final String type = errortype;
  }
  public static String gettype(){
    return type;
  }
  public static String getmessage(){
    return errormessage;
  }
}
