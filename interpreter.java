import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
public class interpreter{
  public static String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public static void interpreter(String[] args){
    private final String[] custom = args;
  }
  public static void run(String file_name){
    try{
      String fileName = concate(file_name,".gd");
      File_reader fileHandler = new File_reader(fileName);
      String[] contents = fileHandler.read();
      int a = 1;
      int b = 0;
      String[] command;
      String unparse;
      String inloc = custom[0];
      String tempstring;
      Integer tempint;
      Object result;
      ScriptEngineManager manager = new ScriptEngineManager();
      ScriptEngine engine = new manager.getEngineByName("JavaScript");
      while(a==1){
        try{
          unparse = contents[b];
          command = unparse.split(" ");
          tempstring = command[0];
          if(tempstring.equals("jump")){
            try{
              tempstring = command[1];
              tempint = Integer.valueOf(parseInt(tempstring));
              tempstring = command[2];
              result = engine.eval(tempstring);
              if(result){
                b = tempint;
              }
            } catch(Exception e){
              System.print("");
            }
          }
          b += 1;
        } catch(Exception e){
          a = 0;
        }
      }
    } catch(Exception e){
      System.println(concate(inloc,"\033[31mError[0]:Critical failure\033[0m"));
    }
  }
}
