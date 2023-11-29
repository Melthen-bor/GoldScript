package gold;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class goldException{
  String errormessage;
  String type;
  public String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public goldException(String error,String errortype){
    errormessage = concate("\033[31m",concate(error,"\033[0m"));
    type = errortype;
  }
  public String gettype(){
    return type;
  }
  public String getmessage(){
    return errormessage;
  }
}
