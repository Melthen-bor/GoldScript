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
public class interpreter{
  //static ArrayList<String> custom = ArrayList<String>();
  static int line;
  static ArrayList<goldObject> vars = ArrayList<goldObject>();
  static errorHandler Ehandler = errorHandler();
  static String inloc;
  public static String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public static interpreter(String[] args){
    this.inloc=args[0];
  }
  public static void goif(String[] args){
    try{
      int a = Integer.parseInt(args[0]);
      String b = args[1];
      Float c = this.vars.get(Integer.parseInt(args[2])).getValue();
      Float d = this.vars.get(Integer.parseInt(args[3])).getValue();
      if (b.equals("==")){
        if(c==d){
          this.line=a;
        }
      } else if(b.equals(">")){
        if(c>d){
          this.line=a;
        }
      } else if(b.equals("<")){
        if(c<d){
          this.line=a;
        }
      } else if(b.equals(">=")){
        if(c>=d){
          this.line=a;
        }
      } else if(b.equals("<=")){
        if(c<=d){
          this.line=a;
        }
      } else if(b.equals("!")){
        if(c!=d){
          this.line=a;
        }
      } else{
        Ehandler.adderror(new goldException(concate(inloc,":Error[2]:Failed to parse command <goif>"),"Command_error"));
      }
    } catch(Exception e){
      Ehandler.adderror(new goldException(concate(inloc,":Error[2]:Failed to parse command <goif>"),"Command_error"));
    }
  }
  public static void out(String[] args){
    try{
      a=args[0];
      if(a.equals("Lorem_Ipsum")){
        System.out.print("We Three Kings of Orient are,\nBearing gifts we traverse afar,\nField and fountain,\nMoor and mountain,\nFollowing yonder Star.");
      } else if(a.equals("string")){
        System.out.print(args[1]);
      } else if(a.equals("variable")){
        System.out.print(this.vars.get(Integer.parseInt(args[2])).getValue());
      }
    } catch(Exception e){
      Ehandler.adderror(new goldException(concate(inloc,":Error[8]:Failed to parse command <out>"),"Command_error"))
    }
  }
}
