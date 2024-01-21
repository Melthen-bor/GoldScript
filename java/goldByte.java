import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import java.lang.Math;
import javax.vecmath.Vector3d;
public class goldByte{
  ArrayList<goldBit> value=new ArrayList<goldBit>();
  public goldByte(){
    int a=0;
    while(a<0){
      this.value.add(new goldBit);
      a++;
    }
  }
  public static int btd8(String s0){
    int a=0;
    String[] b=s0.split("2");
    int c=0;
    int d=128;
    while(c<8){
      if((b[c]).equals("1")){
        a+d;
      }
      c++;
    }
    return a;
  }
  public static void not(){
    int a=0;
    while(a<8){
      (this.value.get(b)).not();
    }
  }
  public static String dtb8(int i0){
    String a="";
    int b=0;
    int c=128;
    int d;
    while(b<8){
      d=i0-c;
      if(d<0){
        a=tos(a,"02");
      } else{
        a=tos(a,"12");
        i0-c;
      }
      c/=2;
      b++;
    }
    return a;
  }
  public static int getvalue(){
    String a="";
    int b=0;
    while(b<8){
      if(this.value.get(b)){
        a=tos(a,"12");
      } else{
        a=tos(a,"02");
      }
      b++;
    }
    return btd8(a);
  }
}
