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
  goldBit sign=new goldBit();
  public goldByte(int sign){
    int a=0;
    while(a<0){
      this.value.add(new goldBit);
      a++;
    }
    if(sign=1){
      this.sign.not();
    }
  }
  public static int btd7(String s0){
    int a=0;
    String[] b=s0.split("2");
    int c=0;
    int d=64;
    while(c<7){
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
  public static String dtb7(int i0){
    String a="";
    int b=0;
    int c=64;
    int d;
    while(b<7){
      d=i0-c;
      if(d<0){
        a=tos(a,"0");
      } else{
        a=tos(a,"1");
        i0-c;
      }
      c/=2;
      b++;
    }
    return a;
  }
  public static int getvalue(){
    
  }
}
