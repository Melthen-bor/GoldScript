package com.gold.gold;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import com.gold.gold.file_reader;
import com.gold.gold.errorHandler;
import com.gold.gold.goldException;
public class interpreter{
  public static String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public static void interpreter(String[] args){
    final String[] custom = args;
  }
  public static String run(String file_name){
    try{
      String fileName = concate(file_name,".gd");
      file_reader fileHandler = new file_reader(fileName);
      String[] contents = fileHandler.read();
      int a = 1;
      int b = 0;
      String[] command;
      String unparse;
      String inloc;
      try{
        inloc = custom[0];
      } catch(Exception e){
        inloc = "Gold_Program";
      }
      String tempstring;
      Integer tempint;
      Integer tempintii;
      Integer tempintiii;
      String temptype;
      Object result;
      String[] tempcontents;
      /*ScriptEngineManager manager = new ScriptEngineManager();
      ScriptEngine engine = new manager.getEngineByName("JavaScript");*/
      goldException lastgolderror;
      errorHandler Ehandler = new errorHandler();
      interpreter tempinter;
      String ret = "";
      String[] vars;
      while(a==1){
        try{
          unparse = contents[b];
          command = unparse.split(" ");
          tempstring = command[0];
          if(tempstring.equals("goif")){
            try{
              tempstring = command[1];
              tempint = Integer.valueOf(tempstring);
              tempstring = command[2];
              tempintii = Integer.valueOf(command[3]);
              tempintiii = Integer.valueOf(command[4]);
              tempintii = Integer.valueOf(vars[tempintii]);
              tempintiii = Integer.valueOf(vars[tempintiii]);
              if(tempstring.equals("equals")){
                if(tempintii==tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals("greater_than"){
                if(tempintii>tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals("less_than"){
                if(tempintii<tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals("greater_or_equals"){
                if(tempintii>=tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals("less_or_equals"){
                if(tempintii<=tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals("not"){
                if(tempintii!=tempintiii){
                  b = tempint;
                }
              }
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,concate(":","Error[2]:Failed to parse command \<goif\>")),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("go")){
            try{
              tempstring = command[1];
              tempint = Integer.valueOf(tempstring);
              b = tempint;
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,concate(":","Error[1]:Failed to parse command \<go\>")),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("throw")){
            try{
              tempstring = command[1];
              try{
                temptype = command[2];
                if(temptype.equals("Command_error"){
                  temptype = "Thrown_error";
                }
              } catch(Exception e){
                temptype = "Thrown_error";
              }
            } catch(Exception e){
              tempstring = "Error[?]undefined";
              temptype = "Thrown_error";
            }
            lastgolderror = new goldException(concate(inloc,concate(":",tempstring)),temptype);
            Ehandler.adderror(lastgolderror);
          } else if(tempstring.equals("import")){
            try{
              tempstring = command[1];
              tempint = Integer.valueOf(command[2]);
              tempinter = new interpreter();
              vars[tempint] = tempinter.run(tempstring);
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[3\:failed to parse command \<import\>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("return"){
            try{
              tempstring = command[1];
              ret = tempstring;
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[4]:failed to parse command \<return\>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("assign"){
            try{
              tempint = Integer.valueOf(command[1]);
              tempstring = command[2];
              vars[tempint] = tempstring;
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[5]:Failed to parse command \<assign\>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else{
            lastgolderror = new goldException(concate(inloc,concate(":","Error[0]:unknown command")),"Command_error");
            Ehandler.adderror(lastgolderror);
          }
          b += 1;
        } catch(Exception e){
          a = 0;
        }
      }
    } catch(Exception e){
      System.println("Gold_interpreter:\033[31mError[0]:Critical failure\033[0m\nor program ended");
      Ehandler.rethrow();
    }
  return ret;
  }
}
