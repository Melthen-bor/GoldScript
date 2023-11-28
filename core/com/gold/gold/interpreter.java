//package gold;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
public class interpreter{
  ArrayList<String> custom = new ArrayList<String>();
  public String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public interpreter(String[] args){
    custom.addAll(Arrays.asList(args));
  }
  public String run(String file_name){
    String ret = "";
    errorHandler Ehandler = new errorHandler();
    try{
      String fileName = concate(file_name,".gd");
      file_reader fileHandler = new file_reader(fileName);
      ArrayList<String> contents = new ArrayList<String>();
      contents.addAll(Arrays.asList(fileHandler.read()));
      int a = 1;
      int b = 0;
      ArrayList<String> command = new ArrayList<String>();
      String unparse;
      String inloc;
      try{
        inloc = custom.get(0);
      } catch(Exception e){
        inloc = "Gold_Program";
      }
      String tempstring;
      Integer tempint;
      Integer tempintii;
      Integer tempintiii;
      String temptype;
      Object result;
      tempstring = new String("a");
      String[] templist = [tempstring];
      goldException lastgolderror;
      interpreter tempinter;
      ArrayList<String> vars = new ArrayList<String>();
      while(a==1){
        try{
          unparse = contents.get(b);
          command.addAll(Arrays.asList(unparse.split(" ")));
          tempstring = command.get(0);
          //This is where the included functions are defined
          if(tempstring.equals("goif")){
            try{
              tempstring = command.get(1);
              tempint = Integer.valueOf(tempstring);
              tempstring = command.get(2);
              tempintii = Integer.valueOf(command.get(3));
              tempintiii = Integer.valueOf(command.get(4));
              tempintii = Integer.valueOf(vars.get(tempintii));
              tempintiii = Integer.valueOf(vars.get(tempintiii));
              if(tempstring.equals("equals")){
                if(tempintii==tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals("greater_than")){
                if(tempintii>tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals("less_than")){
                if(tempintii<tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals("greater_or_equals")){
                if(tempintii>=tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals("less_or_equals")){
                if(tempintii<=tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals("not")){
                if(tempintii!=tempintiii){
                  b = tempint;
                }
              }
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,concate(":","Error[2]:Failed to parse command <goif>")),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("go")){
            try{
              tempstring = command.get(1);
              tempint = Integer.valueOf(tempstring);
              b = tempint;
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,concate(":","Error[1]:Failed to parse command <go>")),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("throw")){
            try{
              tempstring = command.get(1);
              try{
                temptype = command.get(2);
                if(temptype.equals("Command_error")){
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
              tempstring = command.get(1);
              tempint = Integer.valueOf(command.get(2));
              templist[0] = command.get(3);
              tempinter = new interpreter(templist);
              vars.set(tempint,tempinter.run(tempstring));
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[3]:failed to parse command <import>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("return")){
            try{
              tempstring = command.get(1);
              ret = tempstring;
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[4]:failed to parse command <return>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("assign")){
            try{
              tempint = Integer.valueOf(command.get(1));
              tempstring = command.get(2);
              vars.set(tempint,tempstring);
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[5]:Failed to parse command <assign>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else{
            lastgolderror = new goldException(concate(inloc,concate(":","Error[0]:unknown command")),"Command_error");
            Ehandler.adderror(lastgolderror);
          }
          command.clear();
          b += 1;
        } catch(Exception e){
          a = 0;
        }
      }
    } catch(Exception e){
      System.out.println("Gold_interpreter:\033[31mError[0]:Critical failure\033[0m\nor program ended");
    }
  Ehandler.rethrow();
  return ret;
  }
}
