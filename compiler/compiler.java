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
public class compiler{
  private final String TAB = "^I";
  private static char Look;
  private static int line;
  public static String concate(Object s0,Object s1){
    return s0+""+s1;
  }
  public static compiler(){
    this.line = 0;
  }
  public static String parseList(String[] list,String l){
    int a = 1;
    int b = 1;
    String c = list[0];
    while(a==1){
      try{
        c = concate(c,concate(l,list[1]));
      } catch(Exception e){
        a = 0;
      }
    }
    return c
  }
  public static void compile(String fileName){
    try{
      file_reader source = new file_reader(concate(fileName,".gold"));
      ArrayList<String> content = new ArrayList<String>();
      content.addAll(source.read());
      int a = 1;
      int b = 0;
      ArrayList<String> command = new ArrayList<String>();
      String tempstring;
      String replace = "";
      file_reader include;
      while(a==1){
        try{
          command.addAll((content.get(b)).split(" "));
          tempstring = command.get(0);
          if(tempstring.equals("jump")){
            replace = concate(replace,concate("JMP rel32 ",command.get(1)));
          } else if(tempstring.equals("jumpif")){
            tempstring = command.get(2);
            if(tempstring.equals("==")){
              replace = concate(replace,concate(concate(concate(concate("IF ",command.get(3)),concate(" = ",command.get(4))),"\n"),concate(concate("  JMP rel32 ",concate(command.get(1),"\n"),"FI"))));
            } else if(tempstring.equals(">")){
              replace = concate(replace,concate(concate(concate(concate("IF ",command.get(3)),concate(" > ",command.get(4))),"\n"),concate(concate("  JMP rel32 ",concate(command.get(1),"\n"),"FI"))));
            } else if(tempstring.equals("<")){
              replace = concate(replace,concate(concate(concate(concate("IF ",command.get(3)),concate(" < ",command.get(4))),"\n"),concate(concate("  JMP rel32 ",concate(command.get(1),"\n"),"FI"))));
            }
          } else if(tempstring.equals("import")){
            include = new file_reader(command.get(1));
            replace = concate(replace,parseList(include.read(),"\n"));
          } else if(tempstring.equals("assign")){
            
          }
          replace = concate(replace,"\n");
        } catch(Exception e){
          a = 0;
        }
      }
    } catch(Exception e){
      System.out.println("\033[31mFailed to Compile\033[0m");
    }
  }
}
