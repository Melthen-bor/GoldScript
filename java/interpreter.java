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
  static ArrayList<String> custom = ArrayList<String>();
  static int line;
  static ArrayList<String> vars = ArrayList<String>();
  public static String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public static interpreter(String[] args){
    this.custom.addAll(Arrays.asList(args));
  }
  public static void goif(String[] args){
    int a = Integer.parseInt(args[0]);
    String b = args[1];
    Float c = Float.valueOf(vars.get(Integer.parseInt(args[2])));
    Float d = Float.valueOf(vars.get(Integer.parseInt(args[3])));
  }
}
