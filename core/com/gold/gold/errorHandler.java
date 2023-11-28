//package gold;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class errorHandler{
  ArrayList<goldException> errors;
  int nexterror;
  public static String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public static void errorHandler(){
    errors = new ArrayList<goldException>();
    nexterror = 0;
  }
  public static void adderror(goldException error){
    errors.add(error);
    nexterror += 1;
  }
  public static void removeerror(){
    errors.remove(nexterror);
    nexterror -= 1;
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
        temp = concate(temp,concate(", ",temperror.gettype));
        System.out.println(temp);
        b += 1;
      } catch(Exception e){
        a = 0;
      }
    }
  }
}
