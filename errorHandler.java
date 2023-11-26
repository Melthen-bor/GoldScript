import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class errorHandler{
  public static String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public static void errorHandler(){
    private static goldException[] errors;
    private static int nexterror;
  }
  public static void adderror(goldException error){
    errors[nexterror] = error;
    nexterror += 1;
  }
  public static void rethrow(){
    int a = 1;
    goldException temperror;
    String temp;
    int b = 0;
    while(a==1){
      try{
        temperror = errors[b];
        temp = temperror.getmessage();
      } catch(Exception e){
        a = 0;
      }
    }
  }
}
